package br.com.tqi.creditanalysis.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    
    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String rg;

    private Double income;

    private String password;

    private Address address;

    private List<Loan> loans;

   
}
