package br.com.tqi.creditanalysis.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientAlreadyRegisteredException extends RuntimeException {

    public ClientAlreadyRegisteredException(String cpf) {
        super(String.format("Client with CPF %s already registered in the system.", cpf));
    }

}
