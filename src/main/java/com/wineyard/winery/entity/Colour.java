package com.wineyard.winery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "colours")
@Setter
@Getter
public class Colour {
    @Id
    @GeneratedValue
    private Integer colourID;
    private String colour;

    @OneToMany(mappedBy = "colour")
    @JsonIgnore
    private List<Wine> wines;
}