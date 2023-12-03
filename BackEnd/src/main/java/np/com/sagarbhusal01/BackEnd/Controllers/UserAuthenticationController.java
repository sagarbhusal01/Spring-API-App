package np.com.sagarbhusal01.BackEnd.Controllers;
import np.com.sagarbhusal01.BackEnd.DataModels.UserAuthenticationDataModel;
import np.com.sagarbhusal01.BackEnd.Repositories.UserAuthenticationSQLRepository;
import np.com.sagarbhusal01.BackEnd.Security.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController()
public class UserAuthenticationController {


    @Autowired
    UserAuthenticationSQLRepository sqlUser;

    @Autowired
    Hashing Encoder;

//
//
//    this method must be deleted before production
//
    @Deprecated
    @GetMapping("/get/{email}")
    public UserAuthenticationDataModel getAllData(@PathVariable("email") String email) {
        return sqlUser.findByEmail(email);
    }

//
//
//

    @PostMapping("/authenticate")
    public Object AuthenticateUser(@RequestBody Map<String, String> Body) {
        UserAuthenticationDataModel StoredData=sqlUser.findByEmail(Body.get("email"));
        String UserInputPassword=Body.get("password");
        if (StoredData != null) {
            if(Encoder.match(UserInputPassword,StoredData.getHashedpassword()))
            {
                return StoredData;
            }
        }
        return "Sorry Email or password donot match";
    }





    @PostMapping("/adduser")
    public Object AddNewUser(@RequestBody Map<String,String> Body) {

        String email = Body.get("email");
        String name = Body.get("name");
        String password = Body.get("password");
        String AccountType = Body.get("account_type");
        String permissions = Body.get("permissions");


        if (sqlUser.findByEmail(email) == null) {
            UserAuthenticationDataModel t = new UserAuthenticationDataModel();
            t.setName(name);
            t.setEmail(email);
            t.setHashedpassword(Encoder.encode(password));
            t.setApikey(Encoder.encode( email + name));
            t.setAccounttype(AccountType);
            t.setPermissions(permissions);
            t.setReadcount(0);
            t.setWritecount(0);
            return sqlUser.save(t);
        }

        else
            return "Email Already Exist";
    }


}