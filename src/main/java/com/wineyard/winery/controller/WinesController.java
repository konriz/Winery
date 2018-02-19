package com.wineyard.winery.controller;

import com.wineyard.winery.entity.Colour;
import com.wineyard.winery.entity.Taste;
import com.wineyard.winery.entity.Wine;
import com.wineyard.winery.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WinesController {

    @Autowired
    private WineRepository wineRepository;

    @GetMapping
    public List<Wine> getWines() {
        return wineRepository.findAll();
    }

    @RequestMapping("/tastes/{taste}")
    public List<Wine> getTastes(@PathVariable("taste") String taste)
    {
        try
        {
            return wineRepository.findByTasteID(Taste.valueOf(taste.toUpperCase()));
        }
        catch (IllegalArgumentException e)
        {
            return wineRepository.findByTasteID(Taste.NONE);
        }

    }

    @RequestMapping("/colours/{colour}")
    public List<Wine> getColours(@PathVariable("colour") String colour)
    {
        try
        {
            return wineRepository.findByColourID(Colour.valueOf(colour.toUpperCase()));
        }
        catch (IllegalArgumentException e)
        {
            return wineRepository.findByColourID(Colour.NONE);
        }

    }

}
