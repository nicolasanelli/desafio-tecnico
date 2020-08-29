package br.com.nicolasanelli.desafio.application.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasanelli.desafio.domain.cep.CEP;
import br.com.nicolasanelli.desafio.domain.cep.SearchCEPService;

@Service
public class CEPApplicationService {

    @Autowired
    private SearchCEPService service;

	public CEPApplicationService(SearchCEPService service) {
        this.service = service;
	}

	public CEPData searchByCode(String code) {
		return buildData(
            service.searchByCode(code));
	}
    
    private CEPData buildData(CEP cep) {
        return new CEPData(
            cep.getCode(),
            cep.getState(),
            cep.getCity(),
            cep.getAddress(),
            cep.getDistrict()
        );
    }

}