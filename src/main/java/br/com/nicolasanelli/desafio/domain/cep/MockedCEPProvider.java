package br.com.nicolasanelli.desafio.domain.cep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MockedCEPProvider implements CEPProvider {

    List<CEP> ceps;

    public MockedCEPProvider() {
        ceps = loadMocks();
    }

    @Override
    public Optional<CEP> findByCode(String code) {
        for (CEP cep : ceps) {
            if (cep.getCode().equals(code))
                return Optional.of(cep);
        }
        return Optional.empty();
    }
    
    private List<CEP> loadMocks() {

        List<CEP> list = new ArrayList<>();

        list.add(new CEP("14050000","SP","Ribeirão Preto","Avenida Fábio Barreto","Vila Tibério"));
        list.add(new CEP("06233030","SP","Osasco","Rua Paula Rodrigues","Piratininga"));
        list.add(new CEP("14050140","SP","Ribeirão Preto","Rua Padre Anchieta","Vila Tibério"));
        list.add(new CEP("14030200","SP","Ribeirão Preto","Rua José Venâncio","Vila Virgínia"));
        list.add(new CEP("01001000","SP","São Paulo","Praça da Sé","Sé"));
        list.add(new CEP("14080120","SP","Ribeirão Preto","Avenida Marechal Costa e Silva","Campos Elíseos"));

        return list;
    }

}