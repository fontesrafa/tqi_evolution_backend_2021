package br.com.tqi.creditanalysis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;


    public List<Client> listAll() {
        return clientRepository.findAll();        
    }

    public Client findById(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public Client findByCpf(String cpf) throws ClientNotFoundException {
        return clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new ClientNotFoundException(cpf));
    }

    public Client createClient(Client client) {
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