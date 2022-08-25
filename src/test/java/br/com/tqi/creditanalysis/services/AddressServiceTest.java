package br.com.tqi.creditanalysis.services;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.tqi.creditanalysis.entities.Address;
import br.com.tqi.creditanalysis.repositories.AddressRepository;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    public AddressRepository addressRepository;

    @InjectMocks
    public AddressService addressService;

    public Address address = new Address("Rua 1", 77L, 55000000L, "Fortaleza", "Ceará", "Brasil");

    @Test
    void testCreateAddress() {
        when(addressRepository.save(address)).thenReturn(address);

        Address createdAddress = addressService.createAddress(address);

        assertThat(createdAddress.getStreet()).isEqualTo("Rua 1");
    }
}
