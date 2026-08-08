package com.smartlostfound.service.impl;

import com.smartlostfound.dto.item.LostItemRequest;
import com.smartlostfound.dto.item.LostItemResponse;
import com.smartlostfound.entity.auth.User;
import com.smartlostfound.entity.item.LostItem;
import com.smartlostfound.exception.ResourceNotFoundException;
import com.smartlostfound.repository.auth.UserRepository;
import com.smartlostfound.repository.item.LostItemRepository;
import com.smartlostfound.service.item.LostItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostItemServiceImpl implements LostItemService {

    private final LostItemRepository lostItemRepository;
    private final UserRepository userRepository;

    public LostItemServiceImpl(LostItemRepository lostItemRepository,
                               UserRepository userRepository) {
        this.lostItemRepository = lostItemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LostItemResponse reportLostItem(LostItemRequest request, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        LostItem lostItem = new LostItem();

        lostItem.setTitle(request.getTitle());
        lostItem.setDescription(request.getDescription());
        lostItem.setCategory(request.getCategory());
        lostItem.setBrand(request.getBrand());
        lostItem.setColor(request.getColor());
        lostItem.setLocation(request.getLocation());
        lostItem.setDateLost(request.getDateLost());
        lostItem.setImageUrl(request.getImageUrl());

        lostItem.setReportedBy(user);

        LostItem savedItem = lostItemRepository.save(lostItem);

        return mapToResponse(savedItem);
    }

    @Override
    public List<LostItemResponse> getAllLostItems() {

        return lostItemRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public LostItemResponse getLostItemById(Long id) {

        LostItem item = lostItemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lost Item not found"));

        return mapToResponse(item);
    }

    @Override
    public void deleteLostItem(Long id) {

        LostItem item = lostItemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lost Item not found"));

        lostItemRepository.delete(item);
    }

    @Override
    public List<LostItemResponse> searchByCategory(String category) {

        return lostItemRepository.findByCategoryIgnoreCase(category)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<LostItemResponse> searchByColor(String color) {

        return lostItemRepository.findByColorIgnoreCase(color)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<LostItemResponse> searchByLocation(String location) {

        return lostItemRepository.findByLocationContainingIgnoreCase(location)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private LostItemResponse mapToResponse(LostItem item) {

        LostItemResponse response = new LostItemResponse();

        response.setId(item.getId());
        response.setTitle(item.getTitle());
        response.setDescription(item.getDescription());
        response.setCategory(item.getCategory());
        response.setBrand(item.getBrand());
        response.setColor(item.getColor());
        response.setLocation(item.getLocation());
        response.setDateLost(item.getDateLost());
        response.setImageUrl(item.getImageUrl());
        response.setStatus(item.getStatus());
        response.setAiMatchScore(item.getAiMatchScore());
        response.setCreatedAt(item.getCreatedAt());

        return response;
    }
}