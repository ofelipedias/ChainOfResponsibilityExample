package br.com.felipesilva.chainofresponsibilityexample.chain;

import br.com.felipesilva.chainofresponsibilityexample.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class ValidateUserExistsValidateHandler extends ValidateHandler {

    @Override
    public void validate(User user) {
        if (Objects.isNull(user.getName())) {
            log.error("User is null");
            throw new RuntimeException("User is null");
        }
        log.info("User exists");
        checkNext(user);
    }
}
