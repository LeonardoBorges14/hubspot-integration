package br.com.hubspot.integration.infrastructure.webhook.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactCreationWebhookRequest(
        @JsonProperty("appId") long appId,
        @JsonProperty("eventId") int eventId,
        @JsonProperty("subscriptionId") long subscriptionId,
        @JsonProperty("portalId") long portalId,
        @JsonProperty("occurredAt") long occurredAt,
        @JsonProperty("subscriptionType") String subscriptionType,
        @JsonProperty("attemptNumber") int attemptNumber,
        @JsonProperty("objectId") long objectId,
        @JsonProperty("changeSource") String changeSource,
        @JsonProperty("changeFlag") String changeFlag
) {
}

