package br.com.hubspot.integration.infrastructure.webhook.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

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
    public Map<String, Object> toMap() {
        return Map.of(
                "appId", appId,
                "eventId", eventId,
                "subscriptionId", subscriptionId,
                "portalId", portalId,
                "occurredAt", occurredAt,
                "subscriptionType", subscriptionType,
                "attemptNumber", attemptNumber,
                "objectId", objectId,
                "changeSource", changeSource,
                "changeFlag", changeFlag
        );
    }
}

