package br.com.hubspot.integration.domain.contact;


import br.com.hubspot.integration.domain.Entity;
import lombok.Getter;

@Getter
public class Contact extends Entity<ContactID>{
    private String email;
    private String firstname;
    private String lastname;
    private String website;
    private String company;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;

    protected Contact(
            final ContactID id,
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
        super(id);
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.website = website;
        this.company = company;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public static Contact with(
            final ContactID id,
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
        return new Contact(
                id,
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

    public static Contact newContact(
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
        return new Contact(
                null,
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
