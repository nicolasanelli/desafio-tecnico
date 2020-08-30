package br.com.nicolasanelli.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7298953556215240276L;

    public BusinessException() {
        super();
    }
    public BusinessException(String message) {
        super(message);
    }
}