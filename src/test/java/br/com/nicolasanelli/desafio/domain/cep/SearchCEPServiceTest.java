package br.com.nicolasanelli.desafio.domain.cep;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SearchCEPServiceTest {
    
    @Mock
    private CEP cep;

    @Mock
    private CEPProvider provider;

    private SearchCEPService service;

    @BeforeEach
    public void before() {
        service = new SearchCEPService(provider);
    }

    @Test
    public void searchByCode() {

        String code = "14050000";
        given(provider.findByCode(code))
            .willReturn(Optional.of(cep));

        CEP cepFound = service.searchByCode(code);

        assertSame(cep, cepFound);

        then(provider).should().findByCode(code);
    }

    @Test
    public void searchByCodeWithHyphen() {

        String code = "14050000";
        given(provider.findByCode(code))
            .willReturn(Optional.of(cep));

        CEP cepFound = service.searchByCode("14050-000");

        assertSame(cep, cepFound);

        then(provider).should().findByCode(code);
    }

    @Test
    public void searchByCodeWithWrongSize() {

        assertThrows(RuntimeException.class, () -> {
            service.searchByCode("1234567");
        }, "CEP Inválido");

        assertThrows(RuntimeException.class, () -> {
            service.searchByCode("123456789");
        }, "CEP Inválido");

        assertThrows(RuntimeException.class, () -> {
            service.searchByCode("1234-567");
        }, "CEP Inválido");

        assertThrows(RuntimeException.class, () -> {
            service.searchByCode("1234--567");
        }, "CEP Inválido");
    }

    @Test
    public void searchByCodeWhenNeedReplaceZeros() {

        given(provider.findByCode("14050999")).willReturn(Optional.empty());
        given(provider.findByCode("14050990")).willReturn(Optional.empty());
        given(provider.findByCode("14050900")).willReturn(Optional.empty());
        given(provider.findByCode("14050000")).willReturn(Optional.of(cep));

        CEP cepFound = service.searchByCode("14050999");

        assertSame(cep, cepFound);

        then(provider).should().findByCode("14050999");
        then(provider).should().findByCode("14050990");
        then(provider).should().findByCode("14050900");
        then(provider).should().findByCode("14050000");
    }

    @Test
    public void searchByCodeWhenNotFound() {

        assertThrows(RuntimeException.class, () -> {
            service.searchByCode("00000000");
        }, "CEP Inválido");
    }
}