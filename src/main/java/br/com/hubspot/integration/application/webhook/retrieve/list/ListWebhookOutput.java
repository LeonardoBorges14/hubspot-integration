package br.com.hubspot.integration.application.webhook.retrieve.list;


import br.com.hubspot.integration.application.webhook.create.WebhookOutput;
import br.com.hubspot.integration.domain.webhook.Webhook;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public record ListWebhookOutput(
        List<WebhookOutput> webhooks
) {
    public static ListWebhookOutput from(final List<Webhook> webhooks) {
        return new ListWebhookOutput(
                Stream.ofNullable(webhooks)
                        .flatMap(Collection::stream)
                        .map(WebhookOutput::from)
                        .toList()
        );
    }
}
