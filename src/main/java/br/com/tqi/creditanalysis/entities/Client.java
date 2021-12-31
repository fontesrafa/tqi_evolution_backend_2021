package br.com.tqi.creditanalysis.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(nullable = false)
    private String name;
    
    //@Column(nullable = false, unique = true)
    private String email;
    
    //@Column(nullable = false, unique = true)
    private String cpf;
    
    //@Column(nullable = false, unique = true)
    private String rg;
    
    private Double income;
    
    private String password;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Loan> loans;
   
}
