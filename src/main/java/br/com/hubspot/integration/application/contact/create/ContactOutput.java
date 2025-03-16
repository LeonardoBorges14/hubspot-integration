package br.com.hubspot.integration.application.contact.create;


import br.com.hubspot.integration.domain.contact.Contact;
import br.com.hubspot.integration.domain.contact.ContactID;

public record ContactOutput(
        ContactID id,
        String email,
        String firstname,
        String lastname,
        String website,
        String company,
        String phone,
        String address,
        String city,
        String state,
        String zip
) {
    public static ContactOutput from(final Contact contact) {
        return new ContactOutput(
                contact.getId(),
                contact.getEmail(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getWebsite(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getAddress(),
                contact.getCity(),
                contact.getState(),
                contact.getZip()
        );
    }
}
