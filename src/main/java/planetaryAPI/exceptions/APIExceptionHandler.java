package planetaryAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleNotFoundException(NotFoundException ex) {
        Map<String, Object> exMap = new HashMap<>();
        exMap.put("message", ex.getMessage());
        exMap.put("status", HttpStatus.NOT_FOUND);
        exMap.put("code", HttpStatus.NOT_FOUND.value());
        exMap.put("timestamp", LocalDateTime.now());
        return exMap;
    }

    private Map<String, String> getFieldErrorMessages(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> exMap = new HashMap<>();
        exMap.put("errors", getFieldErrorMessages(ex));
        exMap.put("status", HttpStatus.BAD_REQUEST);
        exMap.put("code", HttpStatus.BAD_REQUEST.value());
        exMap.put("timestamp", LocalDateTime.now());
        return exMap;
    }
}
