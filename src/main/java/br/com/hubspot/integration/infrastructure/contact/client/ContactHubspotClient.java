package br.com.hubspot.integration.infrastructure.contact.client;

import br.com.hubspot.integration.infrastructure.contact.client.dto.ContactHubspotResponse;
import br.com.hubspot.integration.infrastructure.contact.client.dto.CreateContactHubspotRequest;
import br.com.hubspot.integration.infrastructure.microservices.BasicFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ContactHubspotClient", url = "https://api.hubapi.com/contacts/v1/contact", configuration = BasicFeignConfig.class)
public interface ContactHubspotClient {

    @PostMapping()
    ContactHubspotResponse create(@RequestBody CreateContactHubspotRequest request);
}