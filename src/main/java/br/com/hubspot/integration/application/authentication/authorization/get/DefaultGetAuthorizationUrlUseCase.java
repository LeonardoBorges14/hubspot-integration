package br.com.hubspot.integration.application.authentication.authorization.get;

import br.com.hubspot.integration.domain.authentication.AuthGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultGetAuthorizationUrlUseCase extends GetAuthorizationUrlUseCase {

    private final AuthGateway authGateway;

    @Override
    public AuthorizationUrlOutput execute() {
        var url = this.authGateway.getAuthorizationUrl();
        return AuthorizationUrlOutput.from(url);
    }
}
