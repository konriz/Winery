package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Colour;
import com.wineyard.winery.entity.Taste;
import com.wineyard.winery.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer>{


    List<Wine> findByTasteID(Taste taste);
    List<Wine> findByColourID(Colour colour);


}
