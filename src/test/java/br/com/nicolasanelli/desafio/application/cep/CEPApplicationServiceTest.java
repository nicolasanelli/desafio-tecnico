package br.com.nicolasanelli.desafio.application.cep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.nicolasanelli.desafio.domain.cep.CEP;
import br.com.nicolasanelli.desafio.domain.cep.SearchCEPService;

@ExtendWith(MockitoExtension.class)
public class CEPApplicationServiceTest {
    
    @Mock
    private CEP cep;

    @Mock
    private SearchCEPService searchCEPService;

    private CEPApplicationService applicationService;

    @BeforeEach
    public void setup() {

        given(cep.getCode()).willReturn("14050000");
        given(cep.getState()).willReturn("SP");
        given(cep.getCity()).willReturn("Ribeirão Preto");
        given(cep.getAddress()).willReturn("Avenida Fábio Barreto");
        given(cep.getDistrict()).willReturn("Vila Tibério");
        
        applicationService = new CEPApplicationService(searchCEPService);
    }

    @Test
    public void searchByCode() {

        String code = "14050000";

        given(searchCEPService.searchByCode(code)).willReturn(cep);

        CEPData data = applicationService.searchByCode(code);

        assertEquals("14050000", data.code);
        assertEquals("SP", data.state);
        assertEquals("Ribeirão Preto", data.city);
        assertEquals("Avenida Fábio Barreto", data.address);
        assertEquals("Vila Tibério", data.district);

    }
}