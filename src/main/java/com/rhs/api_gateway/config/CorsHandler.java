package com.rhs.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsHandler {

    @Bean
    public CorsWebFilter corsWebFilter() {
        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList(
                "https://renovation-household-service.vercel.app", // Allow production origin
                "http://localhost:3000"// Allow local development origin
        ));        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("DELETE", "GET"," HEAD","OPTIONS","PATCH","POST","PUT"));
        corsConfig.addAllowedHeader("*");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsWebFilter(source);
    }
}
