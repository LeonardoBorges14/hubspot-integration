package br.com.hubspot.integration.domain;

public abstract class Entity<ID extends Identifier> {
    protected final ID id;

    protected Entity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return this.id;
    }
}