package br.com.hubspot.integration.infrastructure.configuration.usecases;

import br.com.hubspot.integration.application.contact.create.CreateContactUseCase;
import br.com.hubspot.integration.application.contact.create.DefaultCreateContactUseCase;
import br.com.hubspot.integration.domain.contact.ContactGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ContactUseCaseConfig {

    private final ContactGateway contactGateway;

    @Bean
    public CreateContactUseCase createContactUseCase() {
        return new DefaultCreateContactUseCase(contactGateway);
    }


}
