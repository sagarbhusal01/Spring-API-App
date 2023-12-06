package np.com.sagarbhusal01.BackEnd.Controllers;

import np.com.sagarbhusal01.BackEnd.DataModels.APIdataModel;
import np.com.sagarbhusal01.BackEnd.DataModels.UserAuthenticationDataModel;
import np.com.sagarbhusal01.BackEnd.ErrorHandler.LimitReached;
import np.com.sagarbhusal01.BackEnd.ErrorHandler.NoPermissionError;
import np.com.sagarbhusal01.BackEnd.ErrorHandler.NotFoundError;
import np.com.sagarbhusal01.BackEnd.Global.FreeUserLimit;
import np.com.sagarbhusal01.BackEnd.Repositories.APIdataSQLRepository;
import np.com.sagarbhusal01.BackEnd.Repositories.Macros.ReadCountIncrement;
import np.com.sagarbhusal01.BackEnd.Repositories.Macros.WriteCountIncrement;
import np.com.sagarbhusal01.BackEnd.Repositories.UserAuthenticationSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class APIContoller {

    @Autowired
    APIdataSQLRepository apidatasql;
    @Autowired
    UserAuthenticationSQLRepository sqlUser;
    @Autowired
    ReadCountIncrement readCountIncrement;
    @Autowired
    WriteCountIncrement writeCountIncrement;
    @Autowired
    FreeUserLimit freeUserLimit;



    @GetMapping("/api/{api_key}/getall")
    public List<APIdataModel> GETDATA(@PathVariable("api_key") String api_key)  {

        UserAuthenticationDataModel User=sqlUser.findByApikey(api_key);
        if(User==null) {
            throw new NotFoundError();
        }
            List<APIdataModel> ALlData=apidatasql.findAll();
            if(User.getReadcount()<=freeUserLimit.getReadLimit()&& Objects.equals(User.getAccounttype(),"FREE"))
            {

                readCountIncrement.INCREASEBY(api_key,ALlData.size());
                sqlUser.save(User);
                return ALlData;
            }
            else if (Objects.equals(User.getAccounttype(),"PREMIUM"))
            {
                readCountIncrement.INCREASEBY(api_key,ALlData.size());
                sqlUser.save(User);
                return ALlData;
            }
            else throw  new NotFoundError();

    }



    @GetMapping("/api/{api_key}/findbyhospitalid/{hospitalid}")
    public List<APIdataModel> FindDoctorsByHospitalID(@PathVariable("api_key") String api_key,@PathVariable("hospitalid") String hospitalid) {
        UserAuthenticationDataModel User = sqlUser.findByApikey(api_key);
        if (User == null) {
            throw new NotFoundError();
        }

            List<APIdataModel> ALlData=apidatasql.findByHospitalid(hospitalid);

            if(User.getReadcount()<=freeUserLimit.getReadLimit()&& Objects.equals(User.getAccounttype(),"FREE")) {

                readCountIncrement.INCREASEBY(api_key,ALlData.size());
                sqlUser.save(User);
                return ALlData;
            }
            else if (Objects.equals(User.getAccounttype(),"PREMIUM"))
            {
                readCountIncrement.INCREASEBY(api_key,ALlData.size());
                sqlUser.save(User);
                return ALlData;
            }
            else throw new LimitReached();

    }


    @PostMapping("/api/{api_key}/adddata")
    public APIdataModel AddData(@PathVariable("api_key") String api_key, @RequestBody Map<String,String> Body)
    {
        UserAuthenticationDataModel User=sqlUser.findByApikey(api_key);

        if(User==null)
        {
            throw new NotFoundError();
        }
        if(!Objects.equals(User.getPermissions(),"BOTH"))
        {
            throw new NoPermissionError();
        }

            APIdataModel NewApi=new APIdataModel();
            NewApi.setDoctorname(Body.get("doctorname"));
            NewApi.setDoctoraddress(Body.get("doctoraddress"));
            NewApi.setHospitalname(Body.get("hospitalname"));
            NewApi.setHospitalid(Body.get("hospitalid"));


            if(Objects.equals(User.getAccounttype(),"FREE") && User.getWritecount()<=freeUserLimit.getWriteLimit())
            {
                writeCountIncrement.INCREASE(api_key);
                return apidatasql.save(NewApi);
            }
            else if (Objects.equals(User.getAccounttype(),"PREMIUM"))
            {
                writeCountIncrement.INCREASE(api_key);
                return apidatasql.save(NewApi);
            }
        throw new NoPermissionError();

    }



}
