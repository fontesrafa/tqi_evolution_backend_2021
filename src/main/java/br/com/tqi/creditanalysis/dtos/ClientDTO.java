package br.com.tqi.creditanalysis.dtos;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.tqi.creditanalysis.entities.Address;
import br.com.tqi.creditanalysis.entities.Loan;
import lombok.Data;

@Data
public class ClientDTO {
       
    private Long id;
    
    @NotBlank
    private String name;    
    
    @NotBlank
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String username;    
    
    @NotBlank
    @CPF
    private String cpf;    
    
    @NotBlank
    private String rg;
    
    @NotBlank
    private Double income;
    
    @NotBlank
    private String password;

    @NotBlank
    private Boolean active;    
    
    private Address address;    
   
    private List<Loan> loans;   


}
