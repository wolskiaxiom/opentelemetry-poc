package org.wlukasz;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
class InventoryController {

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryResponse> get(@PathVariable Long productId) throws NoSuchAlgorithmException {
        log.info("Got inventory request with productId {}", productId);

        boolean available = SecureRandom.getInstanceStrong().nextLong() % 2 == 1;

        return ResponseEntity.ok(new InventoryResponse(available));
    }

    record InventoryResponse(@Getter boolean available) {
    }
}
