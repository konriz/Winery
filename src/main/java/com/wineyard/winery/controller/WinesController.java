package com.wineyard.winery.controller;

import com.wineyard.winery.entity.*;
import com.wineyard.winery.exceptions.NoItemException;
import com.wineyard.winery.repository.*;
import com.wineyard.winery.tools.HTMLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wines")
public class WinesController {

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GrapesRepository grapesRepository;

    @Autowired
    private ColourRepository colourRepository;

    @Autowired
    private TasteRepository tasteRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public String getWinesHTML() {
            return HTMLBuilder.getWinesHTML("All", wineRepository.findAllDTO());
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<Wine> addWine(@RequestBody Wine wine)
    {
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }



//    @PostMapping()
//    public void addWine(@RequestParam("name") String name, @RequestParam("brand") String brand,
//                        @RequestParam(value = "grapes", required = false) String grapes,
//                        @RequestParam(value = "colour", required = false) String colour,
//                        @RequestParam(value = "taste", required = false) String taste,
//                        @RequestParam(value = "country", required = false) String country,
//                        @RequestParam(value = "year", required = false) String year,
//                        @RequestParam(value = "alcohol", required = false) String alcohol,
//                        @RequestParam(value = "volume", required = false) String volume,
//                        @RequestParam(value = "drinked", required = false) Boolean drinked)
//    {
//        Wine wine = new Wine();
//        wine.setName(name);
//        wine.setBrand(brandRepository.findByBrand(brand));
//        if (grapes != null)
//        {
//            wine.setGrapes(grapesRepository.findByGrapes(grapes));
//        }
//        if (colour != null)
//        {
//            wine.setColour(colourRepository.findByColour(colour));
//        }
//        if (taste != null)
//        {
//            wine.setTaste(tasteRepository.findByTaste(taste));
//        }
//        if (country != null)
//        {
//            wine.setCountry(countryRepository.findByCountry(country));
//        }
//        if (year != null)
//        {
//            try {
//                wine.setYear(Integer.valueOf(year));
//            }
//            catch (NumberFormatException e)
//            {
////              wine.setYear(null);
//            }
//        }
//        if (alcohol != null)
//        {
//            try {
//                wine.setAlcohol(Float.valueOf(alcohol));
//            }
//            catch (NumberFormatException e)
//            {
////                wine.setAlcohol(null);
//            }
//        }
//        if (volume != null)
//        {
//            try {
//                wine.setVolume(Float.valueOf(volume));
//            }
//            catch (NumberFormatException e)
//            {
////                wine.setVolume(null);
//            }
//        }
//        if (drinked)
//        {
//            wine.setDrinked(drinked);
//        }
//
//        wineRepository.save(wine);
//    }


    @PostMapping("/delete")
    public void deleteWine(@RequestParam("name") String name, @RequestParam("brand") String brand)
    {
        wineRepository.deleteWineFromApp(name, brandRepository.findByBrand(brand).getBrandID());
    }

    @RequestMapping("/taste/{taste}")
    public String getDTObyTasteHTML(@PathVariable("taste") String taste)
    {
        return HTMLBuilder.getWinesHTML(taste, wineRepository.findDTObyTaste(taste));
    }

    @RequestMapping("/taste")
    public List<Taste> getTastes()
    {
        return tasteRepository.findAll();
    }

    @RequestMapping("/colour/{colour}")
    public String getDTObyColourHTML(@PathVariable("colour") String colour)
    {
        return HTMLBuilder.getWinesHTML(colour, wineRepository.findDTObyColour(colour));
    }

    @RequestMapping("/colour")
    public List<Colour> getColours()
    {
        return colourRepository.findAll();
    }

    @RequestMapping("/all")
    public List<Wine> getWines()
    {
        return wineRepository.findAll();
    }

    // Grapes part

    @RequestMapping("/grapes")
    public List<Grapes> getGrapes()
    {
        return grapesRepository.findAll();
    }

    @RequestMapping(value = "/grapes", method = RequestMethod.POST)
    public void addGrapes(@RequestParam(name = "grapes") String input)
    {
       grapesRepository.save(new Grapes(input));
    }

    // Brands part

    @RequestMapping("/brand")
    public List<Brand> getBrands()
    {
        return brandRepository.findAll();
    }

    @RequestMapping(value = "/brand", method = RequestMethod.POST)
    public void addBrand(@RequestParam(name = "brand") String input)
    {
        brandRepository.save(new Brand(input));
    }

    // Countries part

    @RequestMapping("/country")
    public List<Country> getCountries()
    {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public void addCountry(@RequestParam(name = "country") String input)
    {
        countryRepository.save(new Country(input));
    }

    @RequestMapping("/error")
    public void getError() throws NoItemException
    {
        throw new NoItemException();
    }

}
