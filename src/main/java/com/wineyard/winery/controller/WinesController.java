package com.wineyard.winery.controller;

import com.wineyard.winery.entity.Wine;
import com.wineyard.winery.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("wines")
public class WinesController {

    @Autowired
    private WineRepository wineRepository;

    @GetMapping
    public List<Wine> getWines() {
        return wineRepository.findAll();
    }

}
