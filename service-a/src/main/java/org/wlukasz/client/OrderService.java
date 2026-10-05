package org.wlukasz.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrderService {

    private final InventoryClient inventoryClient;

    public OrderResponse getOrder(Long orderId) {
        var inventory = inventoryClient.getInventory(orderId);

        return new OrderResponse(
                orderId,
                inventory.available()
        );
    }
}