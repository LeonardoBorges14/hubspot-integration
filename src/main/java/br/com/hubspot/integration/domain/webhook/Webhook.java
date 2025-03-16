package br.com.hubspot.integration.domain.webhook;

import br.com.hubspot.integration.domain.Entity;
import br.com.hubspot.integration.domain.webhook.types.WebhookType;
import lombok.Getter;

import java.util.Map;

@Getter
public class Webhook extends Entity<WebhookID> {
    private WebhookType type;
    private Map<String, Object> value;

    protected Webhook(
            final WebhookID id,
            final WebhookType type,
            final Map<String, Object> value
    ) {
        super(id);
        this.type = type;
        this.value = value;
    }

    public static Webhook with(
            final WebhookID id,
            final WebhookType type,
            final Map<String, Object> value
    ) {
        return new Webhook(
                id,
                type,
                value
        );
    }

    public static Webhook newWebhook(
            final WebhookID id,
            final WebhookType type,
            final Map<String, Object> value
    ) {
        return new Webhook(
                id,
                type,
                value
        );
    }
}
