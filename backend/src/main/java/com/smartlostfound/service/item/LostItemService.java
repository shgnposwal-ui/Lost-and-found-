package com.smartlostfound.service.item;

import com.smartlostfound.dto.item.LostItemRequest;
import com.smartlostfound.dto.item.LostItemResponse;

import java.util.List;

public interface LostItemService {

    // Report Lost Item
    LostItemResponse reportLostItem(LostItemRequest request, String userEmail);

    // Get All Lost Items
    List<LostItemResponse> getAllLostItems();

    // Get Lost Item By Id
    LostItemResponse getLostItemById(Long id);

    // Delete Lost Item
    void deleteLostItem(Long id);

    // Search Lost Items By Category
    List<LostItemResponse> searchByCategory(String category);

    // Search Lost Items By Color
    List<LostItemResponse> searchByColor(String color);

    // Search Lost Items By Location
    List<LostItemResponse> searchByLocation(String location);
}