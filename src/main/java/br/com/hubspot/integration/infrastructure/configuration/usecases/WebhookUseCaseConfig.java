package br.com.hubspot.integration.infrastructure.configuration.usecases;

import br.com.hubspot.integration.application.contact.create.CreateContactUseCase;
import br.com.hubspot.integration.application.contact.create.DefaultCreateContactUseCase;
import br.com.hubspot.integration.application.webhook.create.CreateWebhookUseCase;
import br.com.hubspot.integration.application.webhook.create.DefaultCreateWebhookUseCase;
import br.com.hubspot.integration.application.webhook.retrieve.list.DefaultListWebhookUseCase;
import br.com.hubspot.integration.application.webhook.retrieve.list.ListWebhookUseCase;
import br.com.hubspot.integration.domain.contact.ContactGateway;
import br.com.hubspot.integration.domain.webhook.WebhookGateway;
import io.swagger.v3.oas.annotations.Webhook;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WebhookUseCaseConfig {

    private final WebhookGateway webhookGateway;

    @Bean
    public CreateWebhookUseCase createWebhookUseCase() {
        return new DefaultCreateWebhookUseCase(webhookGateway);
    }

    @Bean
    public ListWebhookUseCase listWebhookUseCase() {
        return new DefaultListWebhookUseCase(webhookGateway);
    }

}
