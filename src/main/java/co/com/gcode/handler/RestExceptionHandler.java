package co.com.gcode.handler;

import co.com.gcode.exception.ResourceNotFoundExceptionDetail;
import co.com.gcode.exception.ResourceNotFoundException;
import co.com.gcode.exception.ValidateExceptionDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundExceptionDetail> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(
                ResourceNotFoundExceptionDetail.builder()
                        .timestamp(LocalDateTime.now())
                        .title("Resource Not Found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .detail(exception.getMessage())
                        .developerMessage(exception.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);

    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest webRequest){

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(""));
        String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(""));

        log.info("Fields error {}", exception.getBindingResult().getFieldErrors());
        return new ResponseEntity<>(
                ValidateExceptionDetail.builder()
                        .timestamp(LocalDateTime.now())
                        .title("Params not valid")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .detail(exception.getMessage())
                        .developerMessage(exception.getClass().getName())
                        .fields(fields)
                        .fieldsMessages(fieldMessage)
                        .build(), HttpStatus.BAD_REQUEST);

    }
}
