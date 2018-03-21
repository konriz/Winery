package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourRepository extends JpaRepository<Colour, Integer>{

    Colour findByColour(String colour);
}
