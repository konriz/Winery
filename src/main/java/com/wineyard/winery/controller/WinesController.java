package com.wineyard.winery.controller;

import com.wineyard.winery.entity.*;
import com.wineyard.winery.repository.WineRepository;
import com.wineyard.winery.tools.HTMLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public String getWinesHTML() {
        return HTMLBuilder.getWinesHTML("All", wineRepository.findAllDTO());
    }

    @RequestMapping("/tastes/{taste}")
    public String getDTObyTasteHTML(@PathVariable("taste") String taste)
    {
        return HTMLBuilder.getWinesHTML(taste, wineRepository.findDTObyTaste(taste));
    }

    @RequestMapping("/tastes")
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

    @RequestMapping("/colours/{colour}")
    public String getDTObyColourHTML(@PathVariable("colour") String colour)
    {
        return HTMLBuilder.getWinesHTML(colour, wineRepository.findDTObyColour(colour));
    }

    @RequestMapping("/all")
    public List<Wine> getWines()
    {
        return wineRepository.findAll();
    }

    //TODO urls for getting other categories

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

}
