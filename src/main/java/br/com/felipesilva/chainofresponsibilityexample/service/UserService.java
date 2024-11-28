package br.com.felipesilva.chainofresponsibilityexample.service;

import br.com.felipesilva.chainofresponsibilityexample.chain.ValidateHandler;
import br.com.felipesilva.chainofresponsibilityexample.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final ValidateHandler validationsChain;

    public void login(User user) {
        log.info("LOGIN User: {}", user);
        validationsChain.validate(user);
        log.info("LOGIN SUCCESSFUL: {}", user.getName());
    }
}
