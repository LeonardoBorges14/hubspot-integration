package br.com.hubspot.integration.application;

public abstract class NullaryUseCase<OUT>  {
    public NullaryUseCase() {
    }
    public abstract OUT execute();
}
