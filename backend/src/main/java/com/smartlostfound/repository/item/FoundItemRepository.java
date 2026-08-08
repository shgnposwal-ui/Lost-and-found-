package com.smartlostfound.repository.item;

import com.smartlostfound.entity.item.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoundItemRepository extends JpaRepository<FoundItem, Long> {

    List<FoundItem> findByCategoryIgnoreCase(String category);

    List<FoundItem> findByColorIgnoreCase(String color);

    List<FoundItem> findByLocationContainingIgnoreCase(String location);

}