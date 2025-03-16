package br.com.hubspot.integration.application.authentication.callback;

import br.com.hubspot.integration.domain.authentication.AuthGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultAuthCallbackUseCase extends AuthCallbackUseCase {

    private final AuthGateway authGateway;

    @Override
    public AuthCallbackOutput execute(AuthCallbackCommand command) {
        var authToken = this.authGateway.callback(command.code());
        return AuthCallbackOutput.from(authToken);
    }
}
