package br.com.tqi.creditanalysis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String teste() {
        return "Teste";
    }
}
