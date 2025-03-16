package br.com.hubspot.integration.application.authentication.callback;

import br.com.hubspot.integration.application.UseCase;
import br.com.hubspot.integration.application.contact.create.ContactOutput;
import br.com.hubspot.integration.application.contact.create.CreateContactCommand;

public abstract class AuthCallbackUseCase extends UseCase<AuthCallbackCommand, AuthCallbackOutput> {
}
