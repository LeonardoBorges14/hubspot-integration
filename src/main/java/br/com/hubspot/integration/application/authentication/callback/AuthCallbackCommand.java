package br.com.hubspot.integration.application.authentication.callback;


public record AuthCallbackCommand(
        String code
) {
    public static AuthCallbackCommand from(
            final String code
    ) {
        return new AuthCallbackCommand(
                code
        );
    }
}
