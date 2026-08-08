package com.smartlostfound.service.item;

import com.smartlostfound.dto.item.FoundItemRequest;
import com.smartlostfound.dto.item.FoundItemResponse;

import java.util.List;

public interface FoundItemService {

    // Report Found Item
    FoundItemResponse reportFoundItem(
            FoundItemRequest request,
            String userEmail
    );

    // Get All Found Items
    List<FoundItemResponse> getAllFoundItems();

    // Get Found Item By Id
    FoundItemResponse getFoundItemById(Long id);

    // Delete Found Item
    void deleteFoundItem(Long id);

    // Search Found Items By Category
    List<FoundItemResponse> searchByCategory(String category);

    // Search Found Items By Color
    List<FoundItemResponse> searchByColor(String color);

    // Search Found Items By Location
    List<FoundItemResponse> searchByLocation(String location);
}