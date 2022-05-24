package br.com.tqi.creditanalysis.dtos;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.tqi.creditanalysis.entities.Address;
import br.com.tqi.creditanalysis.entities.Loan;
import lombok.Data;

@Data
public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 2, max = 30)
    @NotBlank
    private String name;

    @Size(max = 40)
    @NotBlank
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String username;

    @NotBlank(message = "Please enter a valid CPF")
    @CPF
    private String cpf;

    @NotBlank(message = "Please enter a valid RG")
    private String rg;

    @NotNull(message = "Please enter a income")
    private Double income;

    @NotBlank
    @Size(min = 3)
    private String password;

    private Boolean active;

    private Address address;

    private List<Loan> loans;

}
