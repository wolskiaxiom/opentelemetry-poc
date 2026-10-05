package org.wlukasz.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
class InventoryClient {

    private final RestClient restClient;

    public InventoryResponse getInventory(Long productId) {
        return restClient
                .get()
                .uri("/api/inventory/{productId}", productId)
                .retrieve()
                .body(InventoryResponse.class);
    }
}