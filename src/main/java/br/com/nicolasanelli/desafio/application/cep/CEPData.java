package br.com.nicolasanelli.desafio.application.cep;

public class CEPData {
    
    public String code;
    public String state;
    public String city;
    public String address;
    public String district;

    CEPData(String code, String state, String city, String address, String district) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.address = address;
        this.district = district;
    }
}