package br.com.hubspot.integration.infrastructure.configuration.usecases;

import br.com.hubspot.integration.application.authentication.authorization.get.GetAuthorizationUrlUseCase;
import br.com.hubspot.integration.application.authentication.authorization.get.DefaultGetAuthorizationUrlUseCase;
import br.com.hubspot.integration.application.authentication.callback.AuthCallbackUseCase;
import br.com.hubspot.integration.application.authentication.callback.DefaultAuthCallbackUseCase;
import br.com.hubspot.integration.domain.authentication.AuthGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthenticationUseCaseConfig {

    private final AuthGateway authGateway;

    @Bean
    public GetAuthorizationUrlUseCase authAuthorizeUseCase() {
        return new DefaultGetAuthorizationUrlUseCase(authGateway);
    }

    @Bean
    public AuthCallbackUseCase authCallbackUseCase() {
        return new DefaultAuthCallbackUseCase(authGateway);
    }


}
