package xy.com.ProjectManagment.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerAdviceImpl extends ResponseEntityExceptionHandler {
  @ExceptionHandler(UserFormInputException.class)
   public ResponseEntity<ErrorMessage> userNotFound(UserFormInputException ex, WebRequest request) {

     ErrorMessage message = new ErrorMessage(
              HttpStatus.NOT_FOUND.value(),
              new Date(),
              ex.getMessage(),
              request.getDescription(false),
                ex.formElementError
             );
      return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
   }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> userNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                ex.formElementError
        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
