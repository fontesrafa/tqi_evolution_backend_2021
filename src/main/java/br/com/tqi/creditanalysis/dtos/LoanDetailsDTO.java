package br.com.tqi.creditanalysis.dtos;

import java.io.Serializable;
import java.util.List;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Installment;
import lombok.Data;

@Data
public class LoanDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Double amount;

    private Long installmentsAmount;  

    private String firstPaymentDate;
    
    private String clientEmail;
    
    private Double clientIncome;
    
}
