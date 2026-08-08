package com.smartlostfound.service.claim;

import com.smartlostfound.dto.claim.ClaimRequestDto;
import com.smartlostfound.dto.claim.ClaimResponseDto;

import java.util.List;

public interface ClaimService {

    ClaimResponseDto createClaim(ClaimRequestDto request, String userEmail);

    List<ClaimResponseDto> getAllClaims();

    List<ClaimResponseDto> getMyClaims(String userEmail);

    ClaimResponseDto approveClaim(Long claimId);

    ClaimResponseDto rejectClaim(Long claimId);
}