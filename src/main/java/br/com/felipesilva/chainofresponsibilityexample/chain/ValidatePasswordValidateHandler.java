package br.com.felipesilva.chainofresponsibilityexample.chain;

import br.com.felipesilva.chainofresponsibilityexample.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class ValidatePasswordValidateHandler extends ValidateHandler {

    @Override
    public void validate(User user) {
        if (Objects.isNull(user.getPassword()) || user.getPassword().isBlank()) {
            log.error("Password is null or blank");
            throw new RuntimeException("Password is null or blank");
        }
        log.info("Password is valid");
        checkNext(user);
    }
}
