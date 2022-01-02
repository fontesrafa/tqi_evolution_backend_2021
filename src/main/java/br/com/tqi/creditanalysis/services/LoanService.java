package br.com.tqi.creditanalysis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.entities.Loan;
import br.com.tqi.creditanalysis.exceptions.LoanNotFoundException;
import br.com.tqi.creditanalysis.repositories.LoanRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService {
    
    @Autowired
    private LoanRepository loanRepository;

    public Loan applyForLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan findById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));
    }

    public List<Loan> listAll() {
        return loanRepository.findAll();
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
