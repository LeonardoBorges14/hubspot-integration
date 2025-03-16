package br.com.hubspot.integration.infrastructure.contact.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateContactHubspotRequest(
        @JsonProperty("properties") List<CreateContactPropertyHubspotRequest> properties
) {
}

