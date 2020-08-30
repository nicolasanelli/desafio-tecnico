package br.com.nicolasanelli.desafio.application.cep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CEPDataTest {
    
    @Test
    public void create() {

        CEPData data = new CEPData(
            "14050000",
            "SP",
            "Ribeirão Preto",
            "Avenida Fábio Barreto",
            "Vila Tibério"
        );

        assertEquals("14050000", data.code);
        assertEquals("SP", data.state);
        assertEquals("Ribeirão Preto", data.city);
        assertEquals("Avenida Fábio Barreto", data.address);
        assertEquals("Vila Tibério", data.district);
    }

}