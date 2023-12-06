package np.com.sagarbhusal01.BackEnd.ErrorHandler;

public class NotFoundError extends RuntimeException{

    public NotFoundError() {
        super("The resource you are looking for cannot be found within our application");
    }
}
