package org.wlukasz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class RestClientConfig {

    @Bean
    public RestClient restClient(@Value("${inventory.base-url}") String inventoryBaseUrl) {
        return RestClient.builder()
                .baseUrl(inventoryBaseUrl)
                .build();
    }

}
