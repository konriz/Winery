package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer>{


    List<Wine> findByTasteID(Integer tasteID);
    List<Wine> findByColourID(Integer colourID);




}
