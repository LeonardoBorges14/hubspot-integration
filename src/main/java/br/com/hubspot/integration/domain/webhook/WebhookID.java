package br.com.hubspot.integration.domain.webhook;


import br.com.hubspot.integration.domain.Identifier;

public class WebhookID extends Identifier {
    public WebhookID(final String value) {
        super(value);
    }

    public static WebhookID from(final String anId) {
        return new WebhookID(anId.toLowerCase());
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
