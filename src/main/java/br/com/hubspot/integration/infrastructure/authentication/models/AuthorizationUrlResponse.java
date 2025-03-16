package br.com.hubspot.integration.infrastructure.authentication.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorizationUrlResponse(
        @JsonProperty("authorization_url") String url
) {
}
