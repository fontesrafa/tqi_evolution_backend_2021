package br.com.tqi.creditanalysis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> listAll() {
        return clientRepository.findAll();        
    }

    public Client findById(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

}
