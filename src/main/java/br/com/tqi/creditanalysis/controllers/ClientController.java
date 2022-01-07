package br.com.tqi.creditanalysis.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tqi.creditanalysis.controllers.exceptions.ClientNotFoundException;
import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.services.ClientService;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> listAll() {                  
        return clientService.listAll();
    }

    @GetMapping(value = "/user")
    @ResponseStatus(HttpStatus.OK)
    public Principal showLogedUser(Principal principal) {
        return principal;
    } 


    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) throws ClientNotFoundException{
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        clientService.deleteById(id);        
    }

}
