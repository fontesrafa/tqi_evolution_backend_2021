package br.com.tqi.creditanalysis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Installment {

    private Long id;

    private Double value;

    private String date;

}
