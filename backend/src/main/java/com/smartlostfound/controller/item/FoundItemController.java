package com.smartlostfound.controller.item;

import com.smartlostfound.dto.item.FoundItemRequest;
import com.smartlostfound.dto.item.FoundItemResponse;
import com.smartlostfound.service.item.FoundItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/found-items")
@CrossOrigin(origins = "*")
public class FoundItemController {

    private final FoundItemService foundItemService;

    public FoundItemController(FoundItemService foundItemService) {
        this.foundItemService = foundItemService;
    }

    // ===============================
    // Report Found Item
    // ===============================

    @PostMapping
    public ResponseEntity<FoundItemResponse> reportFoundItem(
            @Valid @RequestBody FoundItemRequest request,
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                foundItemService.reportFoundItem(request, email)
        );
    }

    // ===============================
    // Get All Found Items
    // ===============================

    @GetMapping
    public ResponseEntity<List<FoundItemResponse>> getAllFoundItems() {

        return ResponseEntity.ok(
                foundItemService.getAllFoundItems()
        );
    }

    // ===============================
    // Get Found Item By Id
    // ===============================

    @GetMapping("/{id}")
    public ResponseEntity<FoundItemResponse> getFoundItemById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                foundItemService.getFoundItemById(id)
        );
    }

    // ===============================
    // Delete Found Item
    // ===============================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoundItem(
            @PathVariable Long id) {

        foundItemService.deleteFoundItem(id);

        return ResponseEntity.ok("Found Item Deleted Successfully");
    }

    // ===============================
    // Search By Category
    // ===============================

    @GetMapping("/search/category")
    public ResponseEntity<List<FoundItemResponse>> searchByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(
                foundItemService.searchByCategory(category)
        );
    }

    // ===============================
    // Search By Color
    // ===============================

    @GetMapping("/search/color")
    public ResponseEntity<List<FoundItemResponse>> searchByColor(
            @RequestParam String color) {

        return ResponseEntity.ok(
                foundItemService.searchByColor(color)
        );
    }

    // ===============================
    // Search By Location
    // ===============================

    @GetMapping("/search/location")
    public ResponseEntity<List<FoundItemResponse>> searchByLocation(
            @RequestParam String location) {

        return ResponseEntity.ok(
                foundItemService.searchByLocation(location)
        );
    }
}