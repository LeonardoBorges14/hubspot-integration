package br.com.hubspot.integration.infrastructure.contact.client.dto;

public record ContactPropertiesHubspotResponse(
        HubspotPropertyValueResponse website,
        HubspotPropertyValueResponse city,
        HubspotPropertyValueResponse firstname,
        HubspotPropertyValueResponse zip,
        HubspotPropertyValueResponse lastname,
        HubspotPropertyValueResponse company,
        HubspotPropertyValueResponse phone,
        HubspotPropertyValueResponse state,
        HubspotPropertyValueResponse address,
        HubspotPropertyValueResponse email
) {

}
