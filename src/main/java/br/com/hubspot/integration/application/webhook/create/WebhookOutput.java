package br.com.hubspot.integration.application.webhook.create;


import br.com.hubspot.integration.domain.webhook.Webhook;
import br.com.hubspot.integration.domain.webhook.WebhookID;
import br.com.hubspot.integration.domain.webhook.types.WebhookType;

import java.util.Map;

public record WebhookOutput(
        WebhookID id,
        WebhookType type,
        Map<String, Object> value
) {
    public static WebhookOutput from(final Webhook webhook) {
        return new WebhookOutput(
                webhook.getId(),
                webhook.getType(),
                webhook.getValue()
        );
    }
}
