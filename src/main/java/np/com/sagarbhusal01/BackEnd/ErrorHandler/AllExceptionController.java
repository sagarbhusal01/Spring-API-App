package np.com.sagarbhusal01.BackEnd.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionController {



    @ExceptionHandler(value = {NotAuthorized.class})
    public ResponseEntity<Object> NotAuthorizedExceptionHandler(NotAuthorized notAuthorized)
    {
        ExceptionModel ErrorObject=new ExceptionModel(HttpStatus.UNAUTHORIZED,notAuthorized.getMessage());
        return  new ResponseEntity<>(ErrorObject,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {NotFoundError.class})
    public ResponseEntity<Object> ResourceNotFound(NotFoundError notFoundError)
    {
        ExceptionModel ErrorObject=new ExceptionModel(HttpStatus.NOT_FOUND,notFoundError.getMessage());
        return new ResponseEntity<>(ErrorObject,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {EmailExists.class})
    public ResponseEntity<Object> EmailExists(EmailExists emailExists)
    {
        ExceptionModel ErrorObject=new ExceptionModel(HttpStatus.NOT_ACCEPTABLE,emailExists.getMessage());
        return new ResponseEntity<>(ErrorObject,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = {LimitReached.class})
    public ResponseEntity<Object> FreeLimitReached(LimitReached limitReached)
    {
        ExceptionModel ErrorObject=new ExceptionModel(HttpStatus.NOT_ACCEPTABLE,limitReached.getMessage());
        return new ResponseEntity<>(ErrorObject,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = {NoPermissionError.class})
    public ResponseEntity<Object> NoPermissionErrorHandler(NoPermissionError noPermissionError)
    {
        ExceptionModel ErrorObject=new ExceptionModel(HttpStatus.NOT_ACCEPTABLE,noPermissionError.getMessage());
        return new ResponseEntity<>(ErrorObject,HttpStatus.NOT_ACCEPTABLE);
    }

}
