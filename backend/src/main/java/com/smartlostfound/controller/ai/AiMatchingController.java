package com.smartlostfound.controller.ai;

import com.smartlostfound.service.ai.AiMatchingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AiMatchingController {

    private final AiMatchingService aiMatchingService;

    public AiMatchingController(AiMatchingService aiMatchingService) {
        this.aiMatchingService = aiMatchingService;
    }

    @PostMapping("/match")
    public ResponseEntity<String> matchItems() {

        aiMatchingService.calculateMatches();

        return ResponseEntity.ok("AI Matching Completed Successfully");
    }
}