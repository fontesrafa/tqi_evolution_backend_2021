package br.com.tqi.creditanalysis.dtos;

import lombok.Data;

@Data
public class LoanSummaryDTO {

    private Long id;

    private Double amount;

    private Long installmentsAmount;

}
