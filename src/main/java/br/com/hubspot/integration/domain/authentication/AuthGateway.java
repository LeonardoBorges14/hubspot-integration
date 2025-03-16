package br.com.hubspot.integration.domain.authentication;


public interface AuthGateway {
    String getAuthorizationUrl();
    AuthToken callback(String code);

}