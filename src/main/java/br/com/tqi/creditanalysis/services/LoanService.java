package br.com.tqi.creditanalysis.services;


import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.controllers.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.controllers.exceptions.LoanNotFoundException;
import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Loan;
import br.com.tqi.creditanalysis.repositories.ClientRepository;
import br.com.tqi.creditanalysis.repositories.LoanRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService {
    
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Loan applyForLoan(Loan loan, Principal principal) throws ClientNotFoundException{
        Client client = clientRepository.findByUsername(principal.getName())
                                .orElseThrow(() -> new ClientNotFoundException(principal.getName()));
        loan.setClient(client);
        return loanRepository.save(loan);
    }

    public Loan findById(Long id, Principal principal) {
        return loanRepository.findById(id).filter(loan -> loan.getClient().getUsername().equals(principal.getName()))
                .orElseThrow(() -> new LoanNotFoundException(id));
    }

    public List<Loan> listAll(Principal principal) {
        
        return loanRepository.findAll().stream().filter(loan -> loan.getClient().getUsername().equals(principal.getName())).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        verifyIfExists(id);
        loanRepository.deleteById(id);        
    }

    private Loan verifyIfExists(Long id) throws LoanNotFoundException {
        return loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));
    }
}
