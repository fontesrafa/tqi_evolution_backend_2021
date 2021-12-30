package br.com.tqi.creditanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tqi.creditanalysis.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
    

