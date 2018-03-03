package com.wineyard.winery.controller;

import com.wineyard.winery.entity.Brand;
import com.wineyard.winery.entity.Colour;
import com.wineyard.winery.entity.Taste;
import com.wineyard.winery.entity.WineDTO;
import com.wineyard.winery.repository.BrandRepository;
import com.wineyard.winery.repository.WineRepository;
import com.wineyard.winery.tools.HTMLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("/wines")
public class WinesController {

    @Autowired
    private WineRepository wineRepository;

//    @PersistenceContext
//    private EntityManager entityManager;

    @GetMapping
    public String getWines() {
        return HTMLBuilder.getWinesHTML(wineRepository.findAll());
    }

    @RequestMapping("/dto")
    public List<WineDTO> getDTO()
    {
        return wineRepository.findAllDTO();
    }

    @RequestMapping("/tastes/{taste}")
    public List<WineDTO> getDTObyTaste(@PathVariable("taste") String taste)
    {
        return wineRepository.findDTObyTaste(taste);
    }

    @RequestMapping("/colours/{colour}")
    public List<WineDTO> getDTObyColour(@PathVariable("colour") String colour)
    {
        return wineRepository.findDTObyColour(colour);
    }

}
