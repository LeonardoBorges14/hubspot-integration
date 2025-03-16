package br.com.hubspot.integration.infrastructure.authentication.api;

import br.com.hubspot.integration.application.authentication.authorization.get.GetAuthorizationUrlUseCase;
import br.com.hubspot.integration.application.authentication.callback.AuthCallbackCommand;
import br.com.hubspot.integration.application.authentication.callback.AuthCallbackUseCase;
import br.com.hubspot.integration.infrastructure.authentication.models.AuthCallbackResponse;
import br.com.hubspot.integration.infrastructure.authentication.models.AuthorizationUrlResponse;
import br.com.hubspot.integration.infrastructure.authentication.presenters.AuthenticationPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController implements AuthenticationAPI {

    private final GetAuthorizationUrlUseCase getAuthorizationUrlUseCase;
    private final AuthCallbackUseCase authCallbackUseCase;

    @Override
    public ResponseEntity<AuthorizationUrlResponse> getAuthorizationUrl() {
        var output = this.getAuthorizationUrlUseCase.execute();
        var response = AuthenticationPresenter.present(output);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AuthCallbackResponse> callback(String code) {
        var command = AuthCallbackCommand.from(code);
        var output = this.authCallbackUseCase.execute(command);
        var response = AuthenticationPresenter.present(output);
        return ResponseEntity.ok(response);
    }
}
