package br.com.hubspot.integration.infrastructure.webhook.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WebhookListResponse(
        @JsonProperty("total") int total,
        @JsonProperty("webhooks") List<WebhookResponse> webhooks

) {
}

