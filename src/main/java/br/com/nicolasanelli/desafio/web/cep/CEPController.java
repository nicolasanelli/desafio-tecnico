package br.com.nicolasanelli.desafio.web.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolasanelli.desafio.application.cep.CEPApplicationService;
import br.com.nicolasanelli.desafio.application.cep.CEPData;

@RestController
public class CEPController {
    
    @Autowired
    private final CEPApplicationService service;

    public CEPController(final CEPApplicationService service) {
        this.service = service;
    }

    @GetMapping(path = "/cep")
    public CEPData search(@RequestParam(required=true) String code) {
        return service.searchByCode(code);
    }

}