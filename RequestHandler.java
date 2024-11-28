package br.com.felipesilva.chain;

public interface RequestHandler {
    void setNextHandler(RequestHandler nextHandler);
    void handleRequest(String requestType);
}