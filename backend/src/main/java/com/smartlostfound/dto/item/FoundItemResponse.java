package com.smartlostfound.dto.item;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FoundItemResponse {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String brand;
    private String color;
    private String location;
    private LocalDate dateFound;
    private String imageUrl;
    private String status;
    private Double aiMatchScore;
    private LocalDateTime createdAt;

    public FoundItemResponse() {
    }

    public FoundItemResponse(Long id, String title, String description,
                             String category, String brand, String color,
                             String location, LocalDate dateFound,
                             String imageUrl, String status,
                             Double aiMatchScore,
                             LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.location = location;
        this.dateFound = dateFound;
        this.imageUrl = imageUrl;
        this.status = status;
        this.aiMatchScore = aiMatchScore;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateFound() {
        return dateFound;
    }

    public void setDateFound(LocalDate dateFound) {
        this.dateFound = dateFound;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAiMatchScore() {
        return aiMatchScore;
    }

    public void setAiMatchScore(Double aiMatchScore) {
        this.aiMatchScore = aiMatchScore;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}