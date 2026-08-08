package com.smartlostfound.service.ai;

import com.smartlostfound.entity.item.FoundItem;
import com.smartlostfound.entity.item.LostItem;
import com.smartlostfound.repository.item.FoundItemRepository;
import com.smartlostfound.repository.item.LostItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiMatchingServiceImpl implements AiMatchingService {

    private final LostItemRepository lostItemRepository;
    private final FoundItemRepository foundItemRepository;

    public AiMatchingServiceImpl(LostItemRepository lostItemRepository,
                                 FoundItemRepository foundItemRepository) {
        this.lostItemRepository = lostItemRepository;
        this.foundItemRepository = foundItemRepository;
    }

    @Override
    public void calculateMatches() {

        List<LostItem> lostItems = lostItemRepository.findAll();
        List<FoundItem> foundItems = foundItemRepository.findAll();

        for (LostItem lost : lostItems) {

            double bestScore = 0;

            for (FoundItem found : foundItems) {

                double score = calculateScore(lost, found);

                if (score > bestScore) {
                    bestScore = score;
                }
            }

            lost.setAiMatchScore(bestScore);

            lostItemRepository.save(lost);
        }
    }

    private double calculateScore(LostItem lost, FoundItem found) {

        double score = 0;

        if (equalsIgnoreCase(lost.getCategory(), found.getCategory()))
            score += 25;

        if (equalsIgnoreCase(lost.getColor(), found.getColor()))
            score += 20;

        if (equalsIgnoreCase(lost.getBrand(), found.getBrand()))
            score += 20;

        if (containsIgnoreCase(lost.getLocation(), found.getLocation()))
            score += 15;

        if (containsIgnoreCase(lost.getTitle(), found.getTitle()))
            score += 20;

        return score;
    }

    private boolean equalsIgnoreCase(String a, String b) {

        if (a == null || b == null)
            return false;

        return a.equalsIgnoreCase(b);
    }

    private boolean containsIgnoreCase(String a, String b) {

        if (a == null || b == null)
            return false;

        return a.toLowerCase().contains(b.toLowerCase())
                || b.toLowerCase().contains(a.toLowerCase());
    }
}