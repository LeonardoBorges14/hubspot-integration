package br.com.hubspot.integration.infrastructure.webhook.persistence;

import br.com.hubspot.integration.domain.webhook.Webhook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebhookConversionService {

    public WebhookJpaEntity from(Webhook webhook) {
        return new WebhookJpaEntity(
                Long.getLong(webhook.getId().getValue()),
                webhook.getType(),
                webhook.getValue()
        );
    }
}
