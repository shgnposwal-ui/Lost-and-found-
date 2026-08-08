package com.smartlostfound.service.impl;

import com.smartlostfound.dto.item.FoundItemRequest;
import com.smartlostfound.dto.item.FoundItemResponse;
import com.smartlostfound.entity.auth.User;
import com.smartlostfound.entity.item.FoundItem;
import com.smartlostfound.exception.ResourceNotFoundException;
import com.smartlostfound.repository.auth.UserRepository;
import com.smartlostfound.repository.item.FoundItemRepository;
import com.smartlostfound.service.item.FoundItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundItemServiceImpl implements FoundItemService {

    private final FoundItemRepository foundItemRepository;
    private final UserRepository userRepository;

    public FoundItemServiceImpl(FoundItemRepository foundItemRepository,
                                UserRepository userRepository) {
        this.foundItemRepository = foundItemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FoundItemResponse reportFoundItem(FoundItemRequest request, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        FoundItem foundItem = new FoundItem();

        foundItem.setTitle(request.getTitle());
        foundItem.setDescription(request.getDescription());
        foundItem.setCategory(request.getCategory());
        foundItem.setBrand(request.getBrand());
        foundItem.setColor(request.getColor());
        foundItem.setLocation(request.getLocation());
        foundItem.setDateFound(request.getDateFound());
        foundItem.setImageUrl(request.getImageUrl());

        foundItem.setReportedBy(user);

        FoundItem savedItem = foundItemRepository.save(foundItem);

        return mapToResponse(savedItem);
    }

    @Override
    public List<FoundItemResponse> getAllFoundItems() {

        return foundItemRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public FoundItemResponse getFoundItemById(Long id) {

        FoundItem item = foundItemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Found Item not found"));

        return mapToResponse(item);
    }

    @Override
    public void deleteFoundItem(Long id) {

        FoundItem item = foundItemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Found Item not found"));

        foundItemRepository.delete(item);
    }

    @Override
    public List<FoundItemResponse> searchByCategory(String category) {

        return foundItemRepository.findByCategoryIgnoreCase(category)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<FoundItemResponse> searchByColor(String color) {

        return foundItemRepository.findByColorIgnoreCase(color)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<FoundItemResponse> searchByLocation(String location) {

        return foundItemRepository.findByLocationContainingIgnoreCase(location)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private FoundItemResponse mapToResponse(FoundItem item) {

        FoundItemResponse response = new FoundItemResponse();

        response.setId(item.getId());
        response.setTitle(item.getTitle());
        response.setDescription(item.getDescription());
        response.setCategory(item.getCategory());
        response.setBrand(item.getBrand());
        response.setColor(item.getColor());
        response.setLocation(item.getLocation());
        response.setDateFound(item.getDateFound());
        response.setImageUrl(item.getImageUrl());
        response.setStatus(item.getStatus());
        response.setAiMatchScore(item.getAiMatchScore());
        response.setCreatedAt(item.getCreatedAt());

        return response;
    }
}