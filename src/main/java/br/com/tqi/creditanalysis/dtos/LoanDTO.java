package br.com.tqi.creditanalysis.dtos;

import java.util.List;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Installment;
import lombok.Data;

@Data
public class LoanDTO {

    private Long id;

    private Double amount;

    private String status;

    private String firstPaymentDate;

    private Long installmentsAmount;    
   
    private Client client;    
    
    private List<Installment> installments;
    
}
