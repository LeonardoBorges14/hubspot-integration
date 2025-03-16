package br.com.hubspot.integration.infrastructure.authentication.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthCallbackResponse(
        @JsonProperty("refresh_token") String refreshToken,
        @JsonProperty("access_token") String accessToken
) {
}
