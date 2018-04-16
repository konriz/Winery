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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="grapesID")
    private Grapes grapes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="brandID")
    private Brand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="countryID")
    private Country country;

    private Integer year;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tasteID")
    private Taste taste;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colourID")
    private Colour colour;

    private Float alcohol;
    private Float volume;

    private Boolean drinked;

}