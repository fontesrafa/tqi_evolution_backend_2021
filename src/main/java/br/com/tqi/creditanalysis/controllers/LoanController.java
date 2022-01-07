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
import br.com.tqi.creditanalysis.controllers.exceptions.LoanNotFoundException;
import br.com.tqi.creditanalysis.entities.Loan;
import br.com.tqi.creditanalysis.services.LoanService;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> listAll(Principal principal) {
        return loanService.listAll(principal);
    }

    @GetMapping(value = "/{id}")
    public Loan findById(@PathVariable Long id, Principal principal) throws LoanNotFoundException{
        return loanService.findById(id, principal);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan applyForLoan(@RequestBody Loan loan, Principal principal) {
        return loanService.applyForLoan(loan, principal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        loanService.deleteById(id);        
    }

}
