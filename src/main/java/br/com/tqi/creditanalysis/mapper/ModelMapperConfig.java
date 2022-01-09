package br.com.tqi.creditanalysis.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.tqi.creditanalysis.dtos.LoanDetailsDTO;
import br.com.tqi.creditanalysis.entities.Loan;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Loan.class, LoanDetailsDTO.class)
            .<Double>addMapping(src -> src.getClient().getIncome(), 
                                (dest, value) -> dest.setClientIncome(value))
            .<String>addMapping(src -> src.getClient().getUsername(), 
                                (dest, value) -> dest.setClientEmail(value));  
        return modelMapper;
    }

}
