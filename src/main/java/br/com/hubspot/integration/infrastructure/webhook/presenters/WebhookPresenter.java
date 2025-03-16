package br.com.hubspot.integration.infrastructure.webhook.presenters;

import br.com.hubspot.integration.application.webhook.create.WebhookOutput;
import br.com.hubspot.integration.application.webhook.retrieve.list.ListWebhookOutput;
import br.com.hubspot.integration.infrastructure.webhook.models.WebhookListResponse;
import br.com.hubspot.integration.infrastructure.webhook.models.WebhookResponse;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface WebhookPresenter {

    static WebhookResponse present(final WebhookOutput output) {
        return new WebhookResponse(
                output.id().getValue(),
                output.type().getValue(),
                output.value()
        );
    }

    static WebhookListResponse present(final ListWebhookOutput output) {
        return new WebhookListResponse(
                Optional.ofNullable(output.webhooks())
                        .map(List::size)
                        .orElse(0),
                Stream.ofNullable(output.webhooks())
                        .flatMap(Collection::stream)
                        .map(WebhookPresenter::present)
                        .toList()
        );
    }

}
