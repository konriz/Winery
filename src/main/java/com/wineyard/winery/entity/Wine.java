package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

@Entity
@Table(name = "wines")
@Getter
@Setter
public class Wine {

    @Id
    @GeneratedValue
    private Integer wineID;
    private String name;
    private Integer grapesID;

    @Column(name = "brandID", insertable = false, updatable = false)
    private Integer brandID;

    @ManyToOne()
    @JoinColumn(name="brandID")
    private Brand brand;

    @Column(name = "countryID", insertable = false, updatable = false)
    private Integer countryID;

    @ManyToOne()
    @JoinColumn(name="countryID")
    private Country country;

    private Integer year;

    @Column(insertable = false, updatable = false)
    private Integer tasteID;

    @ManyToOne()
    @JoinColumn(name = "tasteID")
    private Taste taste;

    @Column(insertable = false, updatable = false)
    private Integer colourID;

    @ManyToOne()
    @JoinColumn(name = "colourID")
    private Colour colour;

//    @Enumerated(EnumType.ORDINAL)
//    private Taste tasteID;
//
//    @Enumerated(EnumType.ORDINAL)
//    private Colour colourID;

    private Float alcohol;
    private Float volume;

}