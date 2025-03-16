package br.com.hubspot.integration.infrastructure.contact.client.dto;

import br.com.hubspot.integration.domain.contact.Contact;
import br.com.hubspot.integration.domain.contact.ContactID;

public record ContactHubspotResponse(
        long vid,
        ContactPropertiesHubspotResponse properties
) {
    public Contact toDomain() {
        return Contact.with(
                ContactID.from(String.valueOf(vid)),
                properties.email().value(),
                properties.firstname().value(),
                properties.lastname().value(),
                properties.website().value(),
                properties.company().value(),
                properties.phone().value(),
                properties.address().value(),
                properties.city().value(),
                properties.state().value(),
                properties.zip().value()
        );
    }

}