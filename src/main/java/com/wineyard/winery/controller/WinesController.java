package com.wineyard.winery.controller;

import com.wineyard.winery.entity.Brand;
import com.wineyard.winery.entity.Colour;
import com.wineyard.winery.entity.Taste;
import com.wineyard.winery.repository.BrandRepository;
import com.wineyard.winery.repository.WineRepository;
import com.wineyard.winery.tools.HTMLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/wines")
public class WinesController {

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private BrandRepository brandRepository;

    // JSON mapping

//    @GetMapping
//    public List<Wine> getWines() {
//        return wineRepository.findAll();
//    }

//    @RequestMapping("/brands")
//    public List<Brand> getBrands()
//    {
//        return brandRepository.findAll();
//    }

//    @RequestMapping("/tastes/{taste}")
//    public List<Wine> getTastes(@PathVariable("taste") String taste)
//    {
//        try
//        {
//            return wineRepository.findByTasteID(Taste.valueOf(taste.toUpperCase()));
//        }
//        catch (IllegalArgumentException e)
//        {
//            return wineRepository.findByTasteID(Taste.NONE);
//        }
//    }

//    @RequestMapping("/colours/{colour}")
//    public List<Wine> getColours(@PathVariable("colour") String colour)
//    {
//        try
//        {
//            return wineRepository.findByColourID(Colour.valueOf(colour.toUpperCase()));
//        }
//        catch (IllegalArgumentException e)
//        {
//            return wineRepository.findByColourID(Colour.NONE);
//        }
//    }

    // HTML mapping

    @GetMapping
    public String getWines() {
        return HTMLBuilder.getWinesHTML(wineRepository.findAll());
    }

    @RequestMapping("/brands")
    public List<Brand> getBrand()
    {
        return brandRepository.findAll();
    }

    @RequestMapping("/brands/{id}")
    public Brand getBrand(@PathVariable("id") Integer id)
    {
        return brandRepository.findOne(id);
    }


    @RequestMapping("/tastes/{taste}")
    public String getTastes(@PathVariable("taste") Integer taste)
    {
        try
        {
            return HTMLBuilder.getWinesHTML(wineRepository.findByTasteID(taste));
        }
        catch (IllegalArgumentException e)
        {
            return HTMLBuilder.getNoWine();
        }
    }

    @RequestMapping("/colours/{colour}")
    public String getColours(@PathVariable("colour") Integer colour)
    {
        try
        {
            return HTMLBuilder.getWinesHTML(wineRepository.findByColourID(colour));
        }
        catch (IllegalArgumentException e)
        {
            return HTMLBuilder.getNoWine();
        }
    }

}
