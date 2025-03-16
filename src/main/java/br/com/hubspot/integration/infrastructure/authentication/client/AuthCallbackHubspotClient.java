package br.com.hubspot.integration.infrastructure.authentication.client;

import br.com.hubspot.integration.infrastructure.authentication.client.dto.AuthCallbackHubspotResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AuthCallbackHubspotClient", url = "https://api.hubapi.com/oauth/v1/token")
public interface AuthCallbackHubspotClient {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AuthCallbackHubspotResponse callback(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );
}