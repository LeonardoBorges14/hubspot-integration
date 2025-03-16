package br.com.hubspot.integration.application.webhook.create;

import br.com.hubspot.integration.domain.webhook.Webhook;
import br.com.hubspot.integration.domain.webhook.WebhookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCreateWebhookUseCase extends CreateWebhookUseCase {

    private final WebhookGateway webhookGateway;

    @Override
    public WebhookOutput execute(CreateWebhookCommand command) {
        var webhook = Webhook.newWebhook(
                command.id(),
                command.type(),
                command.value()
        );
        return WebhookOutput.from(this.webhookGateway.create(webhook));
    }
}
