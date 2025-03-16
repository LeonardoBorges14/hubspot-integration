package br.com.hubspot.integration.infrastructure.authentication.presenters;

import br.com.hubspot.integration.application.authentication.authorization.get.AuthorizationUrlOutput;
import br.com.hubspot.integration.application.authentication.callback.AuthCallbackOutput;
import br.com.hubspot.integration.infrastructure.authentication.models.AuthCallbackResponse;
import br.com.hubspot.integration.infrastructure.authentication.models.AuthorizationUrlResponse;

public interface AuthenticationPresenter {

    static AuthCallbackResponse present(final AuthCallbackOutput output) {
        return new AuthCallbackResponse(
                output.refreshToken(),
                output.accessToken()
        );
    }

    static AuthorizationUrlResponse present(final AuthorizationUrlOutput output) {
        return new AuthorizationUrlResponse(
                output.url()
        );
    }

}
