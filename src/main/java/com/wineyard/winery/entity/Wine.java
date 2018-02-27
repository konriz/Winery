package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wines")
@Getter
@Setter
public class Wine {

    // TODO do this one to many shit!ææ

    @Id
    @GeneratedValue
    private Integer wineID;
    private String name;
    private Integer grapesID;
    private Integer brandID;
    private Integer countryID;
    private Integer year;

    @Enumerated(EnumType.ORDINAL)
    private Taste tasteID;

    @Enumerated(EnumType.ORDINAL)
    private Colour colourID;

    private Float alcohol;
    private Float volume;

}