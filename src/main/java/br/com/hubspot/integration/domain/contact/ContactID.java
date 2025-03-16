package br.com.hubspot.integration.domain.contact;


import br.com.hubspot.integration.domain.Identifier;

public class ContactID extends Identifier {
    public ContactID(final String value) {
        super(value);
    }

    public static ContactID from(final String anId) {
        return new ContactID(anId.toLowerCase());
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
