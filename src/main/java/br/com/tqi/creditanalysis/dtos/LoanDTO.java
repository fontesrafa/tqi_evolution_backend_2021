package br.com.tqi.creditanalysis.dtos;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.entities.Installment;
import lombok.Data;

@Data
public class LoanDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Double amount;

    private String status;

    private String firstPaymentDate;

    @Max(value = 60)
    @Min(value = 1)
    private Long installmentsAmount;    
   
    private Client client;    
    
    private List<Installment> installments;
    
}
