package br.com.tqi.creditanalysis.resources;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import br.com.tqi.creditanalysis.dtos.ClientDTO;
import br.com.tqi.creditanalysis.entities.Client;
import br.com.tqi.creditanalysis.services.ClientService;
import br.com.tqi.creditanalysis.services.exceptions.ClientNotFoundException;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> listAll() {
        return clientService.listAll()
                .stream()
                .map(this::toClientDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/user")
    @ResponseStatus(HttpStatus.OK)
    public Principal showLogedUser(Principal principal) {
        return principal;
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) throws ClientNotFoundException {
        Client client = clientService.findById(id);
        return toClientDTO(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = toClient(clientDTO);
        return toClientDTO(clientService.createClient(client));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        clientService.deleteById(id);
    }

    private ClientDTO toClientDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    private Client toClient(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

}
