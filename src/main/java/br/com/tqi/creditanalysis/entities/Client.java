package br.com.tqi.creditanalysis.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String username;
    
    //@Column(nullable = false, unique = true)
    private String cpf;
    
    //@Column(nullable = false, unique = true)
    private String rg;
    
    private Double income;
    
    private String password;

    private Boolean active;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;
    
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade=CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();
    
}
