package br.com.nicolasanelli.desafio.domain.cep;

public class CEP {
    
    private String code;
    private String state;
    private String city;
    private String address;
    private String district;

    CEP(String code, String state, String city, String address, String district) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.address = address;
        this.district = district;
    }
    
    public String getCode() {
        return code;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public String getDistrict() {
        return district;
    }
}