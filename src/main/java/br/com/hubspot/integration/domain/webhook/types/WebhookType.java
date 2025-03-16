package br.com.hubspot.integration.domain.webhook.types;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum WebhookType {
    CONTACT_CREATION("CONTACT_CREATION"),
    CONTACT_UPDATE( "CONTACT_UPDATE");

    private final String value;

    WebhookType(final String value) {
        this.value = value;
    }

    public static Optional<WebhookType> of(final String value) {
        return Arrays.stream(WebhookType.values())
                .filter(it -> it.value.equalsIgnoreCase(value))
                .findFirst();
    }


}
