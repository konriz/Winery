package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue
    @Column(name = "brandID")
    private Integer brandID;
    private String brand;

    @OneToMany(mappedBy = "brand")
    private List<Wine> wines;


}
