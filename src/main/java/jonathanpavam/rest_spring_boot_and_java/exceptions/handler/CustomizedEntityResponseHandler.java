package jonathanpavam.rest_spring_boot_and_java.exceptions.handler;

import jonathanpavam.rest_spring_boot_and_java.exceptions.ExceptionResponse;
import jonathanpavam.rest_spring_boot_and_java.exceptions.UnsuportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice //global controller exception
public class CustomizedEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity <ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){

        ExceptionResponse response = new ExceptionResponse(
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity <ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){

        ExceptionResponse response = new ExceptionResponse(
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
