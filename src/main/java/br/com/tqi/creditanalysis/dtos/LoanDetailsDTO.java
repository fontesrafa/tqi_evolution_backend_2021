package br.com.tqi.creditanalysis.dtos;

import java.util.List;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Installment;
import lombok.Data;

@Data
public class LoanDetailsDTO {

    private Long id;

    private Double amount;

    private Long installmentsAmount;  

    private String firstPaymentDate;
    
    private String clientEmail;
    
    private Double clientIncome;
    
}
