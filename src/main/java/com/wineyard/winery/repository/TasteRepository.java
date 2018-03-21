package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Taste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasteRepository extends JpaRepository<Taste, Integer> {

    Taste findByTaste(String taste);
}
