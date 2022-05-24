package br.com.tqi.creditanalysis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tqi.creditanalysis.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
