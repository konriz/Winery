package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Grapes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrapesRepository extends JpaRepository<Grapes, String>{
}
