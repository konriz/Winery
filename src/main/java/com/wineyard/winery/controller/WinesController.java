package com.wineyard.winery.controller;

import com.wineyard.winery.entity.*;
import com.wineyard.winery.exceptions.NoItemException;
import com.wineyard.winery.repository.BrandRepository;
import com.wineyard.winery.repository.CountryRepository;
import com.wineyard.winery.repository.GrapesRepository;
import com.wineyard.winery.repository.WineRepository;
import com.wineyard.winery.tools.HTMLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public String getWinesHTML() {
            return HTMLBuilder.getWinesHTML("All", wineRepository.findAllDTO());
    }

    @PostMapping()
    public void addWine(@RequestParam("name") String name, @RequestParam("brand") String brand,
                        @RequestParam(value = "grapes", required = false) String grapes)
    {
        Wine wine = new Wine();
        wine.setName(name);
        wine.setBrand(brandRepository.findByBrand(brand));
        if (grapes != null)
        {
            wine.setGrapes(grapesRepository.findByGrapes(grapes));
        }

        wineRepository.save(wine);
    }

    @RequestMapping("/taste/{taste}")
    public String getDTObyTasteHTML(@PathVariable("taste") String taste)
    {
        return HTMLBuilder.getWinesHTML(taste, wineRepository.findDTObyTaste(taste));
    }

    @RequestMapping("/taste")
    public List<Taste> getTastes()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object> cq = cb.createQuery();
        Root<Taste> from = cq.from(Taste.class);

        CriteriaQuery<Object> select = cq.select(from);
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();

        List<Taste> returnList = new ArrayList<>();
        for(Object o : resultList)
        {
            returnList.add((Taste) o);
        }
        return returnList;
    }

    @RequestMapping("/colour/{colour}")
    public String getDTObyColourHTML(@PathVariable("colour") String colour)
    {
        return HTMLBuilder.getWinesHTML(colour, wineRepository.findDTObyColour(colour));
    }

    @RequestMapping("/colour")
    public List<Colour> getColours()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object> cq = cb.createQuery();
        Root<Colour> from = cq.from(Colour.class);

        CriteriaQuery<Object> select = cq.select(from);
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();

        List<Colour> returnList = new ArrayList<>();
        for(Object o : resultList)
        {
            returnList.add((Colour) o);
        }
        return returnList;
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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object> cq = cb.createQuery();
        Root<Grapes> from = cq.from(Grapes.class);

        CriteriaQuery<Object> select = cq.select(from);
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();

        List<Grapes> returnList = new ArrayList<>();
        for(Object o : resultList)
        {
            returnList.add((Grapes) o);
        }
        return returnList;
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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object> cq = cb.createQuery();
        Root<Country> from = cq.from(Country.class);

        CriteriaQuery<Object> select = cq.select(from);
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();

        List<Country> returnList = new ArrayList<>();
        for(Object o : resultList)
        {
            returnList.add((Country) o);
        }
        return returnList;
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
