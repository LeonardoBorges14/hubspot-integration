package br.com.hubspot.integration.infrastructure.webhook.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record WebhookResponse(
        @JsonProperty("id") String id,
        @JsonProperty("type") String type,
        @JsonProperty("message") Map<String, Object> value

) {
}

