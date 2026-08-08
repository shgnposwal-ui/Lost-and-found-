package com.smartlostfound.entity.claim;

import com.smartlostfound.entity.auth.User;
import com.smartlostfound.entity.item.FoundItem;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "claim_requests")
public class ClaimRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "found_item_id")
    private FoundItem foundItem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User claimant;

    @Column(length = 1000)
    private String message;

    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        status = "PENDING";
    }

    public ClaimRequest() {
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public FoundItem getFoundItem() {
        return foundItem;
    }

    public void setFoundItem(FoundItem foundItem) {
        this.foundItem = foundItem;
    }

    public User getClaimant() {
        return claimant;
    }

    public void setClaimant(User claimant) {
        this.claimant = claimant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}