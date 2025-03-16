package br.com.hubspot.integration.domain;

import java.util.List;
import java.util.Optional;

public interface CrudGateway<A extends Entity<B>, B extends Identifier> {
    A create(A var1);

    void deleteById(B var1);

    Optional<A> findById(B var1);

    A update(A var1);

    List<A> findAll();
}
