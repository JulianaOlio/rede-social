package br.com.fiap.api.rede_social.controller.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.validation.Validator;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private StandartError err = new StandartError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandartError> entityNotFoundException(
            ControllerNotFoundException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setMessage(e.getMessage());
        err.setError("Entity not found");
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> validation(
            MethodArgumentNotValidException e,
            HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ValidateError validateError = new ValidateError();
        validateError.setTimestamp(Instant.now());
        validateError.setStatus(status.value());
        validateError.setMessage(e.getMessage());
        validateError.setError("Erro de Validação");
        validateError.setPath(request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            validateError.addMensagens(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(validateError);
    }
}
