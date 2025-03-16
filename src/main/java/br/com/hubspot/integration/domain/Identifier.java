package br.com.hubspot.integration.domain;

import java.io.Serializable;

public abstract class Identifier implements Serializable {
    protected String value;

    public Identifier(String value) {
        this.value = value;
    }

    public abstract String getValue();

    public String toString() {
        return this.value;
    }


}