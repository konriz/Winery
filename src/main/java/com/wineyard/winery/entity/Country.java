package com.wineyard.winery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<Wine> wines;

}
