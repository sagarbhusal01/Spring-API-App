package np.com.sagarbhusal01.BackEnd.ErrorHandler;

public class NotAuthorized extends RuntimeException{

    public NotAuthorized(String message) {
        super(message);
    }
}
