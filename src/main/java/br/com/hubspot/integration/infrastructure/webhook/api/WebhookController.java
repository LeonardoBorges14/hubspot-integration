package br.com.hubspot.integration.infrastructure.webhook.api;

import br.com.hubspot.integration.application.webhook.create.CreateWebhookCommand;
import br.com.hubspot.integration.application.webhook.create.CreateWebhookUseCase;
import br.com.hubspot.integration.application.webhook.retrieve.list.ListWebhookUseCase;
import br.com.hubspot.integration.domain.webhook.WebhookID;
import br.com.hubspot.integration.domain.webhook.types.WebhookType;
import br.com.hubspot.integration.infrastructure.webhook.models.ContactCreationWebhookRequest;
import br.com.hubspot.integration.infrastructure.webhook.models.WebhookListResponse;
import br.com.hubspot.integration.infrastructure.webhook.models.WebhookResponse;
import br.com.hubspot.integration.infrastructure.webhook.presenters.WebhookPresenter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class WebhookController implements WebhookAPI {

    private final CreateWebhookUseCase createWebhookUseCase;
    private final ListWebhookUseCase listWebhookUseCase;

    @Override
    public ResponseEntity<WebhookResponse> consumeContactCreation(List<ContactCreationWebhookRequest> request) {
        var contactEventRequest = request.get(0);
        var command = CreateWebhookCommand.from(
                WebhookID.from(String.valueOf(contactEventRequest.eventId())),
                WebhookType.CONTACT_CREATION,
                contactEventRequest.toMap()
        );
        var output = this.createWebhookUseCase.execute(command);
        var response = WebhookPresenter.present(output);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WebhookListResponse> listWebhooks() {
        var output = this.listWebhookUseCase.execute();
        var response = WebhookPresenter.present(output);
        return ResponseEntity.ok(response);
    }
}
