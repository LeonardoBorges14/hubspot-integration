package br.com.hubspot.integration.infrastructure.authentication.client.dto;

import br.com.hubspot.integration.domain.authentication.AuthToken;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthCallbackHubspotResponse(
        @JsonProperty("refresh_token") String refreshToken,
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("expires_in") long expiresIn
) {
    public AuthToken toDomain() {
        return AuthToken.with(
                refreshToken,
                accessToken
        );
    }
}
