package com.smartlostfound.repository.item;

import com.smartlostfound.entity.item.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {

    List<LostItem> findByCategoryIgnoreCase(String category);

    List<LostItem> findByColorIgnoreCase(String color);

    List<LostItem> findByLocationContainingIgnoreCase(String location);

}