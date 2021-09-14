package org.example.testovoe.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FileEmptyException.class)
    public final ResponseEntity<ExceptionResponse> fileEmptyException(FileEmptyException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FileIncorrectFormatException.class)
    public final ResponseEntity<ExceptionResponse> fileIncorrectFormatException(FileIncorrectFormatException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
    @ExceptionHandler(NotSuchUserException.class)
    public final ResponseEntity<ExceptionResponse> notSuchUserException(NotSuchUserException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public final ResponseEntity<ExceptionResponse> sqlException(SQLException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<ExceptionResponse> nullPointerException(NullPointerException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public final ResponseEntity<ExceptionResponse> sizeLimitExceededException(WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse("Превышен максимальный размер загрузки", request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public final ResponseEntity<ExceptionResponse> responseStatusException(ResponseStatusException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getReason(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, ex.getStatus());
    }

    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> validErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError -> validErrors.put(((FieldError) objectError).getField(), objectError.getDefaultMessage()));
        ExceptionValidationResponse exceptionResponse = new ExceptionValidationResponse(validErrors, request.getDescription(false));
        return new ResponseEntity(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected final ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("некорректный JSON", request.getDescription(false));
        return new ResponseEntity(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}