package br.com.nicolasanelli.desafio.domain.cep;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasanelli.desafio.exception.BusinessException;

@Service
public class SearchCEPService {

    public static String ERR_INVALID_CEP = "CEP Inválido";

    Logger logger = LoggerFactory.getLogger(SearchCEPService.class);

    @Autowired
    private CEPProvider provider;

    public SearchCEPService(CEPProvider provider){
        this.provider = provider;
    }
    
    public CEP searchByCode(String code) {
        
        logger.info("Searching CEP by code " + code);

        code = replaceHyphen(code);
        if (!validateCodeLength(code)) {
            throw new BusinessException(ERR_INVALID_CEP);
        }

        Optional<CEP> cepOpt;

        for (int i=7; i>=0; i--) {
            cepOpt = provider.findByCode(code);

            if (cepOpt.isPresent()) {
                return cepOpt.get();
            }

            code = replaceRightWithZerosAtPosition(code, i);
        }
        
        throw new BusinessException(ERR_INVALID_CEP);
    }

    private Boolean validateCodeLength(String code) {
        return code.length() == 8;
    }

    private String replaceHyphen(String code) {
        return code.replace("-", "");
    }

    private String replaceRightWithZerosAtPosition(String code, Integer position) {

        char[] charArray = code.toCharArray();
        charArray[position] = '0';
        return new String(charArray);
    }
}