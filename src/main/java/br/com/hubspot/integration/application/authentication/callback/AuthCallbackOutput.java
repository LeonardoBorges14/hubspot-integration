package br.com.hubspot.integration.application.authentication.callback;


import br.com.hubspot.integration.domain.authentication.AuthToken;

public record AuthCallbackOutput(
        String refreshToken,
        String accessToken
) {
    public static AuthCallbackOutput from(final AuthToken authToken) {
        return new AuthCallbackOutput(
                authToken.getRefreshToken(),
                authToken.getAccessToken()
        );
    }
}
