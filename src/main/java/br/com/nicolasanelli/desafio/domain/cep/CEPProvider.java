package br.com.nicolasanelli.desafio.domain.cep;

import java.util.Optional;

public interface CEPProvider {
    public Optional<CEP> findByCode(String code);
}