package br.com.hubspot.integration.application;

import java.util.function.Function;

public interface Presenter<OUT, T> extends Function<OUT, T> {
}
