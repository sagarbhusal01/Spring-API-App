package np.com.sagarbhusal01.BackEnd.ErrorHandler;
import org.springframework.http.HttpStatus;

public record ExceptionModel(HttpStatus httpStatus, String error) {

}
