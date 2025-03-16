package br.com.hubspot.integration.infrastructure.contact.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactResponse(
        @JsonProperty("id") String id,
        @JsonProperty("email") String email,
        @JsonProperty("firstname") String firstname,
        @JsonProperty("lastname") String lastname,
        @JsonProperty("website") String website,
        @JsonProperty("company") String company,
        @JsonProperty("phone") String phone,
        @JsonProperty("address") String address,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("zip") String zip
) {
}

