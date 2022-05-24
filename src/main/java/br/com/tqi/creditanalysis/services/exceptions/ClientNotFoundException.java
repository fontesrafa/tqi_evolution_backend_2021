package br.com.tqi.creditanalysis.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super(String.format("Client with id %s not found in the system", id));
    }

    public ClientNotFoundException(String username) {
        super(String.format("Client with Username %s not found in the system", username));
    }

}
