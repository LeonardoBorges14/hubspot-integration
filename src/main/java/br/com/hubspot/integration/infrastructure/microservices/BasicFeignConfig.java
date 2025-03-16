package br.com.hubspot.integration.infrastructure.microservices;

import br.com.hubspot.integration.infrastructure.authentication.filter.ApplicationContext;
import br.com.hubspot.integration.infrastructure.authentication.filter.ApplicationContextHolder;
import feign.RequestInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class BasicFeignConfig {
    public BasicFeignConfig() {
    }

    protected String getToken() {
        ApplicationContext appHolder = ApplicationContextHolder.get();
        return Objects.nonNull(appHolder) ? appHolder.accessToken() : null;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return (requestTemplate) -> {
            String currentToken = this.getToken();
            if (StringUtils.isNotEmpty(currentToken)) {
                requestTemplate.header("Authorization", String.format("Bearer %s", currentToken));
            }

        };
    }
}
