package br.com.hubspot.integration.infrastructure.webhook.api;


import br.com.hubspot.integration.infrastructure.authentication.api.AuthAPI;
import br.com.hubspot.integration.infrastructure.webhook.models.ContactCreationWebhookRequest;
import br.com.hubspot.integration.infrastructure.webhook.models.WebhookListResponse;
import br.com.hubspot.integration.infrastructure.webhook.models.WebhookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("webhooks")
@Tag(name = "Webhook")
public interface WebhookAPI extends AuthAPI {

    @PostMapping(value = "consume/contact-creation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Consume contact creation webhook")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = WebhookResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<WebhookResponse> consumeContactCreation(
            @RequestBody List<ContactCreationWebhookRequest> request
    );

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "List all webhooks received")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = WebhookListResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    @SecurityRequirement(name = "auth")
    ResponseEntity<WebhookListResponse> listWebhooks();

}
