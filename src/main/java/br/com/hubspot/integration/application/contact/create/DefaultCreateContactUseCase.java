package br.com.hubspot.integration.application.contact.create;

import br.com.hubspot.integration.domain.contact.Contact;
import br.com.hubspot.integration.domain.contact.ContactGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCreateContactUseCase extends CreateContactUseCase {

    private final ContactGateway contactGateway;

    @Override
    public ContactOutput execute(CreateContactCommand command) {
        var contact = this.contactGateway.create(
                Contact.newContact(
                        command.email(),
                        command.firstname(),
                        command.lastname(),
                        command.website(),
                        command.company(),
                        command.phone(),
                        command.address(),
                        command.city(),
                        command.state(),
                        command.zip()
                )
        );
        return ContactOutput.from(contact);
    }
}
