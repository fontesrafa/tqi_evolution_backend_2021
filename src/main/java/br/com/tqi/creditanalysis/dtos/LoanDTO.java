package br.com.tqi.creditanalysis.dtos;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tqi.creditanalysis.entities.Client;
import lombok.Data;

@Data
public class LoanDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "Please enter a Loan amount")
    private Double amount;

    @NotBlank(message = "Please enter a first PaymentDate")
    private String firstPaymentDate;

    @Max(value = 60, message = "The max amount installment is 60")
    @Min(value = 1, message = "The min amount installment is 1")
    private Long installmentsAmount;

    private Client client;

}
