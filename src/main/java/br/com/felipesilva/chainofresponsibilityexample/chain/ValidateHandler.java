package br.com.felipesilva.chainofresponsibilityexample.chain;

import br.com.felipesilva.chainofresponsibilityexample.domain.User;

import java.util.Objects;

public abstract class ValidateHandler {

    private ValidateHandler nextValidateHandler;

    public abstract void validate(User user);

    public static ValidateHandler createChain(ValidateHandler first, ValidateHandler... chain) {
        ValidateHandler head = first;
        for (ValidateHandler nextInChain : chain) {
            head.nextValidateHandler = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    protected void checkNext(User user) {
        if (Objects.nonNull(nextValidateHandler)) {
            nextValidateHandler.validate(user);
        }
    }
}