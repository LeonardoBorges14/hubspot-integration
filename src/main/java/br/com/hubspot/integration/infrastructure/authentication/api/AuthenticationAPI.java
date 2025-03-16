package br.com.hubspot.integration.infrastructure.authentication.api;


import br.com.hubspot.integration.infrastructure.authentication.models.AuthCallbackResponse;
import br.com.hubspot.integration.infrastructure.authentication.models.AuthorizationUrlResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@RequestMapping("authentication")
@Tag(name = "Authentication")
public interface AuthenticationAPI {

    @GetMapping("/authorization-url")
    @Operation(summary = "Get authorization url")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorization url returned successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            
    })
    ResponseEntity<AuthorizationUrlResponse> getAuthorizationUrl();

    @PostMapping(value = "/callback", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Callback authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Callback occurred successfully"),
            @ApiResponse(responseCode = "500", description = "Callback occurred with error"),

    })
    ResponseEntity<AuthCallbackResponse> callback(
            @RequestParam("code") String code
    );

}
