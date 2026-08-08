package com.smartlostfound.controller.item;

import com.smartlostfound.dto.item.LostItemRequest;
import com.smartlostfound.dto.item.LostItemResponse;
import com.smartlostfound.service.item.LostItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost-items")
@CrossOrigin(origins = "*")
public class LostItemController {

    private final LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
        this.lostItemService = lostItemService;
    }

    // ===============================
    // Report Lost Item
    // ===============================

    @PostMapping
    public ResponseEntity<LostItemResponse> reportLostItem(
            @Valid @RequestBody LostItemRequest request,
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                lostItemService.reportLostItem(request, email)
        );
    }

    // ===============================
    // Get All Lost Items
    // ===============================

    @GetMapping
    public ResponseEntity<List<LostItemResponse>> getAllLostItems() {

        return ResponseEntity.ok(
                lostItemService.getAllLostItems()
        );
    }

    // ===============================
    // Get Lost Item By Id
    // ===============================

    @GetMapping("/{id}")
    public ResponseEntity<LostItemResponse> getLostItemById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                lostItemService.getLostItemById(id)
        );
    }

    // ===============================
    // Delete Lost Item
    // ===============================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLostItem(
            @PathVariable Long id) {

        lostItemService.deleteLostItem(id);

        return ResponseEntity.ok("Lost Item Deleted Successfully");
    }

    // ===============================
    // Search By Category
    // ===============================

    @GetMapping("/search/category")
    public ResponseEntity<List<LostItemResponse>> searchByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(
                lostItemService.searchByCategory(category)
        );
    }

    // ===============================
    // Search By Color
    // ===============================

    @GetMapping("/search/color")
    public ResponseEntity<List<LostItemResponse>> searchByColor(
            @RequestParam String color) {

        return ResponseEntity.ok(
                lostItemService.searchByColor(color)
        );
    }

    // ===============================
    // Search By Location
    // ===============================

    @GetMapping("/search/location")
    public ResponseEntity<List<LostItemResponse>> searchByLocation(
            @RequestParam String location) {

        return ResponseEntity.ok(
                lostItemService.searchByLocation(location)
        );
    }
}