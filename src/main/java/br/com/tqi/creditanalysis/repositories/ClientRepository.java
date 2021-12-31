package br.com.tqi.creditanalysis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tqi.creditanalysis.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Optional<Client> findByCpf(String cpf);
}
    

