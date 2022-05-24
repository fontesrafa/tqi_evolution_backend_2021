package br.com.tqi.creditanalysis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.repositories.ClientRepository;
import br.com.tqi.creditanalysis.services.exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    public AddressService addressService;

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username)
                .orElseThrow(() -> new ClientNotFoundException(username));
    }

    public Client createClient(Client client) {
        client.setAddress(addressService.createAddress(client.getAddress()));
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    public void deleteById(Long id) throws ClientNotFoundException {
        verifyIfExists(id);
        clientRepository.deleteById(id);
    }

    private Client verifyIfExists(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

}