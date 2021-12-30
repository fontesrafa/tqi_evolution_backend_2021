package br.com.tqi.creditanalysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.service.ClientService;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String teste() {
        return "Teste";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

}
