package br.com.nicolasanelli.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<Error> handleBusinessException(BusinessException exception, WebRequest request) {

        return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    class Error {
        public String message;
        Error(String message) {
            this.message = message;
        }
    }
}