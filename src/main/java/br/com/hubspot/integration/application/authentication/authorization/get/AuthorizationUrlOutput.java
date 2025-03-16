package br.com.hubspot.integration.application.authentication.authorization.get;


public record AuthorizationUrlOutput(
        String url
) {
    public static AuthorizationUrlOutput from(final String url) {
        return new AuthorizationUrlOutput(
                url
        );
    }
}
