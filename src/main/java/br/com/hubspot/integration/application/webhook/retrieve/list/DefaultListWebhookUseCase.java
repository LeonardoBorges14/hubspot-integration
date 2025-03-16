package br.com.hubspot.integration.application.webhook.retrieve.list;

import br.com.hubspot.integration.domain.webhook.WebhookGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultListWebhookUseCase extends ListWebhookUseCase {

    private final WebhookGateway webhookGateway;

    @Override
    public ListWebhookOutput execute() {
        return ListWebhookOutput.from(this.webhookGateway.findAll());
    }
}
