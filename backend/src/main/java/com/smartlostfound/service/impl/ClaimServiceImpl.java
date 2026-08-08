package com.smartlostfound.service.claim;

import com.smartlostfound.dto.claim.ClaimRequestDto;
import com.smartlostfound.dto.claim.ClaimResponseDto;
import com.smartlostfound.entity.auth.User;
import com.smartlostfound.entity.claim.ClaimRequest;
import com.smartlostfound.entity.item.FoundItem;
import com.smartlostfound.exception.ResourceNotFoundException;
import com.smartlostfound.repository.auth.UserRepository;
import com.smartlostfound.repository.claim.ClaimRequestRepository;
import com.smartlostfound.repository.item.FoundItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRequestRepository claimRepository;
    private final FoundItemRepository foundItemRepository;
    private final UserRepository userRepository;

    public ClaimServiceImpl(ClaimRequestRepository claimRepository,
                            FoundItemRepository foundItemRepository,
                            UserRepository userRepository) {

        this.claimRepository = claimRepository;
        this.foundItemRepository = foundItemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ClaimResponseDto createClaim(ClaimRequestDto request, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        FoundItem foundItem = foundItemRepository.findById(request.getFoundItemId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Found Item not found"));

        ClaimRequest claim = new ClaimRequest();

        claim.setClaimant(user);
        claim.setFoundItem(foundItem);
        claim.setMessage(request.getMessage());

        ClaimRequest savedClaim = claimRepository.save(claim);

        return mapToResponse(savedClaim);
    }

    @Override
    public List<ClaimResponseDto> getAllClaims() {

        return claimRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClaimResponseDto> getMyClaims(String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return claimRepository.findByClaimant(user)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimResponseDto approveClaim(Long claimId) {

        ClaimRequest claim = claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim not found"));

        claim.setStatus("APPROVED");

        return mapToResponse(claimRepository.save(claim));
    }

    @Override
    public ClaimResponseDto rejectClaim(Long claimId) {

        ClaimRequest claim = claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim not found"));

        claim.setStatus("REJECTED");

        return mapToResponse(claimRepository.save(claim));
    }

    // ==========================
    // DTO Mapper
    // ==========================

    private ClaimResponseDto mapToResponse(ClaimRequest claim) {

        ClaimResponseDto response = new ClaimResponseDto();

        response.setId(claim.getId());
        response.setFoundItemId(claim.getFoundItem().getId());
        response.setItemTitle(claim.getFoundItem().getTitle());
        response.setClaimantName(claim.getClaimant().getFullName());
        response.setClaimantEmail(claim.getClaimant().getEmail());
        response.setMessage(claim.getMessage());
        response.setStatus(claim.getStatus());
        response.setCreatedAt(claim.getCreatedAt());

        return response;
    }
}