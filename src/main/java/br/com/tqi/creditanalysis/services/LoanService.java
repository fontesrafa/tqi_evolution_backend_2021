package br.com.tqi.creditanalysis.services;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Loan;
import br.com.tqi.creditanalysis.repositories.ClientRepository;
import br.com.tqi.creditanalysis.repositories.LoanRepository;
import br.com.tqi.creditanalysis.services.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.services.exceptions.LoanNotFoundException;
import br.com.tqi.creditanalysis.services.exceptions.LoansDateNotElegibleException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Loan applyForLoan(Loan loan, Principal principal) throws ClientNotFoundException {
        LocalDate now = LocalDate.now();
        LocalDate date = loan.getFirstPaymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nowPlus3Months = now.plusMonths(3);

        if (date.isAfter(nowPlus3Months) || date.isBefore(now)) {
            throw new LoansDateNotElegibleException();
        }
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

        return loanRepository.findAll().stream()
                .filter(loan -> loan.getClient().getUsername().equals(principal.getName()))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        verifyIfExists(id);
        loanRepository.deleteById(id);
    }

    private Loan verifyIfExists(Long id) throws LoansDateNotElegibleException {
        return loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));
    }
}
