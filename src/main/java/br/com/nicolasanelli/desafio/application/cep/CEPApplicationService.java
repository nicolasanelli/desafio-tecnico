package br.com.nicolasanelli.desafio.application.cep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasanelli.desafio.domain.cep.CEP;
import br.com.nicolasanelli.desafio.domain.cep.SearchCEPService;
import br.com.nicolasanelli.desafio.exception.BusinessException;

@Service
public class CEPApplicationService {

    @Autowired
    private SearchCEPService service;

    Logger logger = LoggerFactory.getLogger(CEPApplicationService.class);

	public CEPApplicationService(SearchCEPService service) {
        this.service = service;
	}

	public CEPData searchByCode(String code) {
        try {
		    return buildData(service.searchByCode(code));
        } catch (BusinessException exception) {
            logger.error("Search by code "+ code +" failed with '" + exception.getMessage() + "'");
            throw exception;
        }
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