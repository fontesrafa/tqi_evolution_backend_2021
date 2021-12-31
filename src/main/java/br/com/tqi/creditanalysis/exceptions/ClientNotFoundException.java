package br.com.tqi.creditanalysis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super(String.format("Client with id %s not found in the system", id));
    }

    public ClientNotFoundException(String cpf) {
        super(String.format("Client with CPF %s not found in the system", cpf));
    }
    
}
