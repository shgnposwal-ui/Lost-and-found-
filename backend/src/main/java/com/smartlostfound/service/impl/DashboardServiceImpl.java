package com.smartlostfound.service.impl;

import com.smartlostfound.dto.dashboard.DashboardResponse;
import com.smartlostfound.repository.auth.UserRepository;
import com.smartlostfound.repository.item.FoundItemRepository;
import com.smartlostfound.repository.item.LostItemRepository;
import com.smartlostfound.service.dashboard.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final LostItemRepository lostItemRepository;
    private final FoundItemRepository foundItemRepository;

    public DashboardServiceImpl(UserRepository userRepository,
                                LostItemRepository lostItemRepository,
                                FoundItemRepository foundItemRepository) {

        this.userRepository = userRepository;
        this.lostItemRepository = lostItemRepository;
        this.foundItemRepository = foundItemRepository;
    }

    @Override
    public DashboardResponse getDashboardData() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalUsers(userRepository.count());
        response.setTotalLostItems(lostItemRepository.count());
        response.setTotalFoundItems(foundItemRepository.count());

        return response;
    }
}