package br.com.felipesilva.chainofresponsibilityexample.config;

import br.com.felipesilva.chainofresponsibilityexample.chain.ValidateHandler;
import br.com.felipesilva.chainofresponsibilityexample.chain.ValidatePasswordValidateHandler;
import br.com.felipesilva.chainofresponsibilityexample.chain.ValidateUserExistsValidateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateUserConfiguration {

    @Bean
    public ValidateHandler validationsChain(ValidateUserExistsValidateHandler validateUserExistsValidateHandler,
                                            ValidatePasswordValidateHandler validatePasswordValidateHandler) {

        return ValidateHandler.createChain(validateUserExistsValidateHandler, validatePasswordValidateHandler);
    }
}