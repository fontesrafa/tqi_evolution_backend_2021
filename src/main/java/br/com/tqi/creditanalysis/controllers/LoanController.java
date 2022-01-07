package br.com.tqi.creditanalysis.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tqi.creditanalysis.controllers.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Loan;
import br.com.tqi.creditanalysis.services.ClientService;
import br.com.tqi.creditanalysis.services.LoanService;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;
    private ClientService clientService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> listAll() {
        return loanService.listAll();
    }

    @GetMapping(value = "/{id}")
    public Loan findById(@PathVariable Long id) throws ClientNotFoundException{
        return loanService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan applyForLoan(@RequestBody Loan loan, Principal principal ) {        
        Client client = clientService.findByUsername(principal.getName());
        loan.setClient(client);
        return loanService.applyForLoan(loan);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        loanService.deleteById(id);        
    }

}
