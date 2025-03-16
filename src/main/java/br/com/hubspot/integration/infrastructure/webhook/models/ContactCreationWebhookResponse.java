package br.com.hubspot.integration.infrastructure.webhook.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactCreationWebhookResponse(
        @JsonProperty("id") String id
) {
}

