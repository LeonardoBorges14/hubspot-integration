package br.com.hubspot.integration.infrastructure.authentication.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record AuthCallbackRequest(
        @JsonProperty("auth_code") @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        String authCode
) {
}
