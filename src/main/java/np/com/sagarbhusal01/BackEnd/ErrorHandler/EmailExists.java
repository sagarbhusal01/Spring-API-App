package np.com.sagarbhusal01.BackEnd.ErrorHandler;

public class EmailExists extends RuntimeException{
    public EmailExists()
    {
        super("Email Alreay Exists");
    }

}
