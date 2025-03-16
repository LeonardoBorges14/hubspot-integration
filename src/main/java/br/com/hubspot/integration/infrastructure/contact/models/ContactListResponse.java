package br.com.hubspot.integration.infrastructure.contact.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ContactListResponse(
        @JsonProperty("total") long total,
        @JsonProperty("items") List<ContactResponse> items
) {
}
