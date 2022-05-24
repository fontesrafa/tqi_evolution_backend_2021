package br.com.tqi.creditanalysis.dtos;

import java.io.Serializable;

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
