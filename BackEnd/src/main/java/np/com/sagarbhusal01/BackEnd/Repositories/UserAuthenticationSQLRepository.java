package np.com.sagarbhusal01.BackEnd.Repositories;

import np.com.sagarbhusal01.BackEnd.DataModels.UserAuthenticationDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthenticationSQLRepository extends JpaRepository<UserAuthenticationDataModel,Integer> {

    public UserAuthenticationDataModel findByEmail(String email);
     public UserAuthenticationDataModel findByApikey(String apikey);


}

