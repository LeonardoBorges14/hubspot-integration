package br.com.hubspot.integration.domain.authentication;


import lombok.Getter;

@Getter
public class AuthToken {
    private String refreshToken;
    private String accessToken;
    protected AuthToken(
            final String refreshToken,
            final String accessToken
    ) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
    }

    public static AuthToken with(
            final String refreshToken,
            final String accessToken
    ) {
        return new AuthToken(
                refreshToken,
                accessToken
        );
    }
}
