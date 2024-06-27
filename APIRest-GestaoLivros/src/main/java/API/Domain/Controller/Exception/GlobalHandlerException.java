package API.Domain.Controller.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalHandlerException {
    private final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException){
        return new ResponseEntity<>("Livro não encontrado pelo ID informado.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "unexpected server error, see the logs";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>("unexpected server error.", HttpStatus.NOT_FOUND);
    }
}
