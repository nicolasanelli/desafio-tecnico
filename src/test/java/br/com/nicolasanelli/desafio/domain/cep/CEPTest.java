package br.com.nicolasanelli.desafio.domain.cep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CEPTest {
    
    @Test
    public void create() {

        CEP cep = new CEP(
            "14050000",
            "SP",
            "Ribeirão Preto",
            "Avenida Fábio Barreto",
            "Vila Tibério"
        );

        assertEquals("14050000", cep.getCode());
        assertEquals("SP", cep.getState());
        assertEquals("Ribeirão Preto", cep.getCity());
        assertEquals("Avenida Fábio Barreto", cep.getAddress());
        assertEquals("Vila Tibério", cep.getDistrict());
    }

}