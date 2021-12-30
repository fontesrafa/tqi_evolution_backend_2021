package br.com.tqi.creditanalysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

}
