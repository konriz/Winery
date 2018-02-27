package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue
    private int countryID;
    private String country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Collection<Wine> wines;

}
