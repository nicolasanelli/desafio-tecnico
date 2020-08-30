package br.com.nicolasanelli.desafio.domain.cep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MockedCEPProviderTest {
    
    private MockedCEPProvider service;

    @BeforeEach
    public void setup() {
        service = new MockedCEPProvider();
    }

    @Test
    public void findByCode() {

        String code = "14050000";

        Optional<CEP> cepOpt = service.findByCode(code);

        assertTrue(cepOpt.isPresent());
        assertEquals(code, cepOpt.get().getCode());
    }

    @Test
    public void findByCodeWhenCodeNotExist() {

        String code = "14050123";

        Optional<CEP> cepOpt = service.findByCode(code);

        assertTrue(cepOpt.isEmpty());
    }
}