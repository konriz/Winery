package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer>{


}
