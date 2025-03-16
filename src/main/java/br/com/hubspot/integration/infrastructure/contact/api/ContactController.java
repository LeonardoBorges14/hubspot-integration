package br.com.hubspot.integration.infrastructure.contact.api;

import br.com.hubspot.integration.application.contact.create.CreateContactCommand;
import br.com.hubspot.integration.application.contact.create.CreateContactUseCase;
import br.com.hubspot.integration.infrastructure.contact.models.ContactListResponse;
import br.com.hubspot.integration.infrastructure.contact.models.ContactResponse;
import br.com.hubspot.integration.infrastructure.contact.models.CreateContactRequest;
import br.com.hubspot.integration.infrastructure.contact.presenters.ContactPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContactController implements ContactAPI {

    private final CreateContactUseCase createContactUseCase;

    @Override
    public ResponseEntity<ContactResponse> create(CreateContactRequest request) {
        var command = CreateContactCommand.from(
                request.email(),
                request.firstname(),
                request.lastname(),
                request.website(),
                request.company(),
                request.phone(),
                request.address(),
                request.city(),
                request.state(),
                request.zip()
        );
        var output = this.createContactUseCase.execute(command);
        var response = ContactPresenter.present(output);
        return ResponseEntity.ok(response);
    }

}
