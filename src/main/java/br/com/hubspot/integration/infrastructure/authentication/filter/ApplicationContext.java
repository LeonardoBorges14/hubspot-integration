package br.com.hubspot.integration.infrastructure.authentication.filter;

public record ApplicationContext(
        String accessToken
) {
    public static ApplicationContext with(
            final String accessToken
    ) {
        return new ApplicationContext(accessToken);
    }
}
