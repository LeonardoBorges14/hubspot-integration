package br.com.hubspot.integration.infrastructure.contact.api;


import br.com.hubspot.integration.infrastructure.authentication.api.AuthAPI;
import br.com.hubspot.integration.infrastructure.contact.models.ContactListResponse;
import br.com.hubspot.integration.infrastructure.contact.models.ContactResponse;
import br.com.hubspot.integration.infrastructure.contact.models.CreateContactRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("contacts")
@Tag(name = "Contact")
public interface ContactAPI extends AuthAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new contact")
    @SecurityRequirement(name = "auth")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CreateContactRequest.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<ContactResponse> create(
            @Valid @RequestBody CreateContactRequest request
    );

}
