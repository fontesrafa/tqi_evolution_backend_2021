package br.com.tqi.creditanalysis.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
   
    private String email;
    
    private String cpf;
    
    private String rg;
    
    private Double income;
    
    private String password;
    
    @OneToOne
    private Address address;
    
    @OneToMany
    private List<Loan> loans;
   
}
