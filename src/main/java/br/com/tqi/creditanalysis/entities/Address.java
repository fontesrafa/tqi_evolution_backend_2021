package br.com.tqi.creditanalysis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    
    private Long id;

    private String street;

    private Long number;

    private Long postalCode;

    private String city;

    private String state;

    private String country;

}
