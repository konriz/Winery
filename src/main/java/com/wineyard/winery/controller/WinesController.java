package com.wineyard.winery.controller;

import com.wineyard.winery.entity.Brand;
import com.wineyard.winery.entity.Grapes;
import com.wineyard.winery.entity.Wine;
import com.wineyard.winery.entity.WineDTO;
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
    public String getWines() {
        return HTMLBuilder.getWinesHTML("All", wineRepository.findAllDTO());
    }

    @RequestMapping("/tastes/{taste}")
    public String getDTObyTaste(@PathVariable("taste") String taste)
    {
        return HTMLBuilder.getWinesHTML(taste, wineRepository.findDTObyTaste(taste));
    }

    @RequestMapping("/colours/{colour}")
    public String getDTObyColour(@PathVariable("colour") String colour)
    {
        return HTMLBuilder.getWinesHTML(colour, wineRepository.findDTObyColour(colour));
    }

    @RequestMapping("/pages")
    public List<Wine> getWinesPaged()
    {
        return wineRepository.findAll();
    }


    @RequestMapping("/api")
    public List<Grapes> getDTOs()
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
