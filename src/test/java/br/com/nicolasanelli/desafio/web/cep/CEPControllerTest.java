package br.com.nicolasanelli.desafio.web.cep;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import br.com.nicolasanelli.desafio.application.cep.CEPApplicationService;
import br.com.nicolasanelli.desafio.application.cep.CEPData;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CEPControllerTest {
    
    @MockBean
    private CEPApplicationService application;
    
    @Autowired
	private MockMvc mvc;

    private CEPData data;

    @BeforeEach
    public void setup() {

        data = new CEPData(
            "14050000",
            "SP",
            "Ribeirão Preto",
            "Avenida Fábio Barreto",
            "Vila Tibério"
        );
    }

    @Test
    @WithMockUser("luiza")
    public void search() throws Exception {

        given(application.searchByCode("14050000")).willReturn(data);

        this.mvc.perform(get("/cep").param("code", "14050000").accept(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
            .andExpect(jsonPath("$.code", is("14050000")))
            .andExpect(jsonPath("$.state", is("SP")))
            .andExpect(jsonPath("$.city", is("Ribeirão Preto")))
            .andExpect(jsonPath("$.address", is("Avenida Fábio Barreto")))
            .andExpect(jsonPath("$.district", is("Vila Tibério")));
                
    }

}