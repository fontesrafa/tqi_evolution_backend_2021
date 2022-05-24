package br.com.tqi.creditanalysis.resources;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tqi.creditanalysis.dtos.LoanDTO;
import br.com.tqi.creditanalysis.dtos.LoanDetailsDTO;
import br.com.tqi.creditanalysis.dtos.LoanSummaryDTO;
import br.com.tqi.creditanalysis.entities.Loan;
import br.com.tqi.creditanalysis.services.LoanService;
import br.com.tqi.creditanalysis.services.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.services.exceptions.LoanNotFoundException;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoanSummaryDTO> listAll(Principal principal) {
        return loanService.listAll(principal)
                .stream()
                .map(this::toLoanSummaryDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public LoanDetailsDTO findById(@PathVariable Long id, Principal principal) throws LoanNotFoundException {
        Loan loan = loanService.findById(id, principal);
        return toLoanDetailsDTO(loan);
    }

    @PostMapping
    public ResponseEntity<LoanDTO> applyForLoan(@RequestBody @Valid LoanDTO loanDTO, Principal principal) {

        Loan loan = toLoan(loanDTO);

        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse(loanDTO.getFirstPaymentDate());
        LocalDate nowPlus3Months = now.plusMonths(3);

        if (date.isAfter(nowPlus3Months) || date.isBefore(now)) {
            return ResponseEntity.badRequest().build();
        } else {
            LoanDTO loanDTOResponse = toLoanDTO(loanService.applyForLoan(loan, principal));
            return ResponseEntity.accepted().body(loanDTOResponse);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        loanService.deleteById(id);
    }

    private LoanDTO toLoanDTO(Loan loan) {
        return modelMapper.map(loan, LoanDTO.class);
    }

    private LoanSummaryDTO toLoanSummaryDTO(Loan loan) {
        return modelMapper.map(loan, LoanSummaryDTO.class);
    }

    private LoanDetailsDTO toLoanDetailsDTO(Loan loan) {
        return modelMapper.map(loan, LoanDetailsDTO.class);
    }

    private Loan toLoan(LoanDTO loanDTO) {
        return modelMapper.map(loanDTO, Loan.class);
    }

}
