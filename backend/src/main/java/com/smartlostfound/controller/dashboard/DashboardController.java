package com.smartlostfound.controller.dashboard;

import com.smartlostfound.dto.dashboard.DashboardResponse;
import com.smartlostfound.service.dashboard.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboardData() {

        return ResponseEntity.ok(
                dashboardService.getDashboardData()
        );
    }
}