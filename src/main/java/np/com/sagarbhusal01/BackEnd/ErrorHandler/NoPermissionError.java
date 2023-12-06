package np.com.sagarbhusal01.BackEnd.ErrorHandler;

public class NoPermissionError extends RuntimeException{
    public NoPermissionError()
    {
        super("You donot have permission to operate the task");
    }
}
