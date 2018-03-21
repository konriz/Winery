package com.wineyard.winery.repository;

import com.wineyard.winery.entity.Wine;
import com.wineyard.winery.entity.WineDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer>{

    @Transactional
    @Modifying
    @Query("delete from Wine w where w.name = :name and w.brand.brandID = :brand")
    void deleteWineFromApp(@Param("name") String name, @Param("brand") Integer brand);

    @Query("select new com.wineyard.winery.entity.WineDTO(w.name, t.taste, c.colour, b.brand) " +
            "from Wine w " +
            "left join w.colour c " +
            "left join w.taste t " +
            "left join w.brand b " +
            "ORDER BY brand, name")
    List<WineDTO> findAllDTO();

    @Query("select new com.wineyard.winery.entity.WineDTO(w.name, w.taste.taste, w.colour.colour, b.brand) " +
            "from Wine w " +
            "left join w.colour c " +
            "left join w.taste t " +
            "left join w.brand b " +
            "where w.taste.taste = :taste")
    List<WineDTO> findDTObyTaste(@Param("taste") String taste);

    @Query("select new com.wineyard.winery.entity.WineDTO(w.name, w.taste.taste, w.colour.colour, b.brand) " +
            "from Wine w " +
            "left join w.colour c " +
            "left join w.taste t " +
            "left join w.brand b " +
            "where w.colour.colour = :colour")
    List<WineDTO> findDTObyColour(@Param("colour") String colour);
}
