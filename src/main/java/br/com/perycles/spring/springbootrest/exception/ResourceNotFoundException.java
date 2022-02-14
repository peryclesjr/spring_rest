package br.com.perycles.spring.springbootrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 4375798549858172712L;

    public ResourceNotFoundException(String exception) {
        super(exception);
    }
}
