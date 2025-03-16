package br.com.hubspot.integration.infrastructure.authentication.filter;

import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder {
    private static final ThreadLocal<ApplicationContext> holder = new ThreadLocal<>();

    public static ApplicationContext get() {
        return holder.get();
    }
    public static void set(ApplicationContext context) {
        holder.set(context);
    }

    public String getAccessToken() {
        return get().accessToken();
    }


}
