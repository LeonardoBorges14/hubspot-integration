package br.com.hubspot.integration.infrastructure.authentication.gateways;

import br.com.hubspot.integration.domain.authentication.AuthGateway;
import br.com.hubspot.integration.domain.authentication.AuthToken;
import br.com.hubspot.integration.infrastructure.authentication.client.AuthCallbackHubspotClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultAuthGateway implements AuthGateway {
    private static final Logger logger = LogManager.getLogger(DefaultAuthGateway.class);
    private final AuthCallbackHubspotClient callbackClient;

    @Value("${hubspot.client.id}")
    private String clientId;

    @Value("${hubspot.client.secret}")
    private String clientSecret;

    @Value("${hubspot.redirect.uri}")
    private String redirectUri;

    @Value("${hubspot.optional.scope}")
    private String optionalScope;

    @Value("${hubspot.auth.scope}")
    private String authScope;

    @Value("${hubspot.auth.grant.type}")
    private String authGrantType;

    @Value("${hubspot.auth.api.url}")
    private String authApiUrl;

    @Override
    public String getAuthorizationUrl() {
        return String.format("%s?client_id=%s&scope=%s&redirect_uri=%s&optional_scope=%s",
                authApiUrl,
                clientId,
                authScope,
                redirectUri,
                optionalScope
        );
    }

    @Override
    public AuthToken callback(String code) {
        var clientResponse = this.callbackClient.callback(
                authGrantType,
                clientId,
                clientSecret,
                redirectUri,
                code
        );
        return clientResponse.toDomain();
    }

}