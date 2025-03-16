package br.com.hubspot.integration.infrastructure.webhook.persistence;

import br.com.hubspot.integration.domain.webhook.Webhook;
import br.com.hubspot.integration.domain.webhook.WebhookGateway;
import br.com.hubspot.integration.domain.webhook.WebhookID;
import br.com.hubspot.integration.infrastructure.webhook.persistence.WebhookConversionService;
import br.com.hubspot.integration.infrastructure.webhook.persistence.WebhookJpaEntity;
import br.com.hubspot.integration.infrastructure.webhook.persistence.WebhookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DefaultWebhookGateway implements WebhookGateway {

    private final WebhookConversionService conversionService;

    private final WebhookJpaRepository repository;

    @Override
    public Webhook create(Webhook webhook) {
        var entity = this.conversionService.from(webhook);
        var entitySaved = this.repository.save(entity);
        return entitySaved.toDomain();
    }

    @Override
    public void deleteById(WebhookID webhookId) {

    }

    @Override
    public Optional<Webhook> findById(WebhookID webhookId) {
        return Optional.empty();
    }

    @Override
    public Webhook update(Webhook webhook) {
        return null;
    }

    @Override
    public List<Webhook> findAll() {
        return Stream.ofNullable(this.repository.findAll())
                .flatMap(Collection::stream)
                .map(WebhookJpaEntity::toDomain)
                .toList();
    }

}