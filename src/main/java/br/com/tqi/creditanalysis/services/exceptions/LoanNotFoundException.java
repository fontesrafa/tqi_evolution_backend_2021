package br.com.tqi.creditanalysis.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends RuntimeException {

    public LoanNotFoundException(Long id) {
        super(String.format("Loan with id %s not found in the system", id));
    }
    
}
