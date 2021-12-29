package br.com.tqi.creditanalysis.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    private Long id;

    private Double amount;

    private Client client;

    private List<Installment> installments;
}
