package com.immersion.riot.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiotFeignConfiguration {
    private final String apiKey;

    public RiotFeignConfiguration(@Value("${riot.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    @Bean
    RequestInterceptor riotRequestInterceptor() {
        return requestTemplate -> requestTemplate.header("X-Riot-Token", apiKey);
    }
}
