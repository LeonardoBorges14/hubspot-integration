package br.com.hubspot.integration.infrastructure.authentication.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    public static final String TOKEN_HEADER = "Authorization";

    // TODO WEBHOOK BATENDO, MAS DA ERRO PROVAVELMENTE NO TOKEN :

//    2025-03-16T03:20:34.740Z  WARN 1 --- [nio-8080-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver :
//    Resolved [org.springframework.http.converter.HttpMessageNotReadableException:
//    JSON parse error: Cannot deserialize value of
//    type `br.com.hubspot.integration.infrastructure.webhook.models.ContactCreationWebhookRequest`
//    from Array value (token `JsonToken.START_ARRAY`)]

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            String authorizationHeader = request.getHeader(TOKEN_HEADER);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                var token = authorizationHeader.substring(7);
                var threadLocalContext = ApplicationContext.with(token);
                ApplicationContextHolder.set(threadLocalContext);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
