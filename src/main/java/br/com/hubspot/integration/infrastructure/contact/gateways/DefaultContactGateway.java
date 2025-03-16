package br.com.hubspot.integration.infrastructure.contact.gateways;

import br.com.hubspot.integration.domain.contact.Contact;
import br.com.hubspot.integration.domain.contact.ContactGateway;
import br.com.hubspot.integration.domain.contact.ContactID;
import br.com.hubspot.integration.infrastructure.contact.client.ContactHubspotClient;
import br.com.hubspot.integration.infrastructure.contact.client.dto.CreateContactHubspotRequest;
import br.com.hubspot.integration.infrastructure.contact.client.dto.CreateContactPropertyHubspotRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultContactGateway implements ContactGateway {
    private static final Logger logger = LogManager.getLogger(DefaultContactGateway.class);
    private final ContactHubspotClient client;

    @Override
    public Contact create(Contact contact) {
        var request = new CreateContactHubspotRequest(
                buildContactPropertyList(contact)
        );
        var contactCreatedResponse = this.client.create(request);
        return contactCreatedResponse.toDomain();
    }

    @Override
    public void deleteById(ContactID contactId) {

    }

    @Override
    public Optional<Contact> findById(ContactID contactId) {
        return Optional.empty();
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    private List<CreateContactPropertyHubspotRequest> buildContactPropertyList(Contact contact) {
        return List.of(
                new CreateContactPropertyHubspotRequest("email", contact.getEmail()),
                new CreateContactPropertyHubspotRequest("firstname", contact.getFirstname()),
                new CreateContactPropertyHubspotRequest("lastname", contact.getLastname()),
                new CreateContactPropertyHubspotRequest("website", contact.getWebsite()),
                new CreateContactPropertyHubspotRequest("company", contact.getCompany()),
                new CreateContactPropertyHubspotRequest("phone", contact.getPhone()),
                new CreateContactPropertyHubspotRequest("address", contact.getAddress()),
                new CreateContactPropertyHubspotRequest("city", contact.getCity()),
                new CreateContactPropertyHubspotRequest("state", contact.getState()),
                new CreateContactPropertyHubspotRequest("zip", contact.getZip())
        );
    }
}