package np.com.sagarbhusal01.BackEnd.ErrorHandler;

public class LimitReached extends RuntimeException{
    public LimitReached()
    {
        super("The FREE account has reached its limit");
    }

}
