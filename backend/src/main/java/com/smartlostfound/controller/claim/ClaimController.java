package com.smartlostfound.controller.claim;

import com.smartlostfound.dto.claim.ClaimRequestDto;
import com.smartlostfound.dto.claim.ClaimResponseDto;
import com.smartlostfound.service.claim.ClaimService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins = "*")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    // ==========================
    // Create Claim
    // ==========================

    @PostMapping
    public ResponseEntity<ClaimResponseDto> createClaim(
            @Valid @RequestBody ClaimRequestDto request,
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                claimService.createClaim(request, email)
        );
    }

    // ==========================
    // Get All Claims
    // ==========================

    @GetMapping
    public ResponseEntity<List<ClaimResponseDto>> getAllClaims() {

        return ResponseEntity.ok(
                claimService.getAllClaims()
        );
    }

    // ==========================
    // Get My Claims
    // ==========================

    @GetMapping("/my")
    public ResponseEntity<List<ClaimResponseDto>> getMyClaims(
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                claimService.getMyClaims(email)
        );
    }

    // ==========================
    // Approve Claim
    // ==========================

    @PutMapping("/{id}/approve")
    public ResponseEntity<ClaimResponseDto> approveClaim(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                claimService.approveClaim(id)
        );
    }

    // ==========================
    // Reject Claim
    // ==========================

    @PutMapping("/{id}/reject")
    public ResponseEntity<ClaimResponseDto> rejectClaim(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                claimService.rejectClaim(id)
        );
    }
}