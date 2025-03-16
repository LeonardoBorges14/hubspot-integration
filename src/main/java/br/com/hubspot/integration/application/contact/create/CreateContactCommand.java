package br.com.hubspot.integration.application.contact.create;


public record CreateContactCommand(
        String email,
        String firstname,
        String lastname,
        String website,
        String company,
        String phone,
        String address,
        String city,
        String state,
        String zip
) {
    public static CreateContactCommand from(
            final String email,
            final String firstname,
            final String lastname,
            final String website,
            final String company,
            final String phone,
            final String address,
            final String city,
            final String state,
            final String zip
    ) {
        return new CreateContactCommand(
                email,
                firstname,
                lastname,
                website,
                company,
                phone,
                address,
                city,
                state,
                zip
        );
    }
}
