package com.smartlostfound.repository.claim;

import com.smartlostfound.entity.claim.ClaimRequest;
import com.smartlostfound.entity.auth.User;
import com.smartlostfound.entity.item.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRequestRepository extends JpaRepository<ClaimRequest, Long> {

    List<ClaimRequest> findByClaimant(User claimant);

    List<ClaimRequest> findByFoundItem(FoundItem foundItem);

    List<ClaimRequest> findByStatus(String status);

}