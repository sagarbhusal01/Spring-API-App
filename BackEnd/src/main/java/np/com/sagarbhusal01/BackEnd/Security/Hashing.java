package np.com.sagarbhusal01.BackEnd.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Hashing {
  BCryptPasswordEncoder b=new BCryptPasswordEncoder();

  public String encode(String rawPassword)
  {
      return b.encode(rawPassword);
  }

    public boolean match(String rawPassword,String HashedPassword)
    {
        return b.matches(rawPassword, HashedPassword);
    }

}
