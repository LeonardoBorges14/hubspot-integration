package br.com.hubspot.integration.application.webhook.create;


import br.com.hubspot.integration.domain.webhook.WebhookID;
import br.com.hubspot.integration.domain.webhook.types.WebhookType;

import java.util.Map;

public record CreateWebhookCommand(
        WebhookID id,
        WebhookType type,
        Map<String, Object> value
) {
    public static CreateWebhookCommand from(
            final WebhookID id,
            final WebhookType type,
            final Map<String, Object> value
    ) {
        return new CreateWebhookCommand(
                id,
                type,
                value
        );
    }
}
