package br.com.hubspot.integration.infrastructure.contact.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateContactPropertyHubspotRequest(
        @JsonProperty("property") String property,
        @JsonProperty("value") String value
) {
}

