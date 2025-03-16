package br.com.hubspot.integration.infrastructure.contact.presenters;

import br.com.hubspot.integration.application.contact.create.ContactOutput;
import br.com.hubspot.integration.infrastructure.contact.models.ContactResponse;

public interface ContactPresenter {

    static ContactResponse present(final ContactOutput output) {
        return new ContactResponse(
                output.id().getValue(),
                output.email(),
                output.firstname(),
                output.lastname(),
                output.website(),
                output.company(),
                output.phone(),
                output.address(),
                output.city(),
                output.state(),
                output.zip()
        );
    }

}
