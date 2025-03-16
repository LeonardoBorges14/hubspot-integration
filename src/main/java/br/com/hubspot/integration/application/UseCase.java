package br.com.hubspot.integration.application;

public abstract class UseCase<IN, OUT> {
    public abstract OUT execute(IN anIn);
}
