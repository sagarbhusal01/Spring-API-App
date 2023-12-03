package np.com.sagarbhusal01.BackEnd.Repositories.Macros;

import np.com.sagarbhusal01.BackEnd.DataModels.UserAuthenticationDataModel;
import np.com.sagarbhusal01.BackEnd.Repositories.UserAuthenticationSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WriteCountIncrement {
    @Autowired
    UserAuthenticationSQLRepository sqlUser;

    public boolean INCREASE(String api_key)
    {
        UserAuthenticationDataModel UserWithAPIkey=sqlUser.findByApikey(api_key);
        if(UserWithAPIkey!=null) {
            UserWithAPIkey.setWritecount(UserWithAPIkey.getWritecount()+1);
            return true;

        }
        else  return false;
    }
    public boolean INCREASEBY(String api_key,int count)
    {
        UserAuthenticationDataModel UserWithAPIkey=sqlUser.findByApikey(api_key);
        if(UserWithAPIkey!=null) {
            UserWithAPIkey.setWritecount(UserWithAPIkey.getWritecount()+count);
            return true;
        }
        else  return false;
    }
}
