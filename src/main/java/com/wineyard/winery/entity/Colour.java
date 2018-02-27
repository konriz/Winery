package com.wineyard.winery.entity;

//public enum Colour {
//
//    NONE, RED, PINK, WHITE;
//
//}

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "colours")
@Setter
@Getter
public class Colour
{
    @Id
    @GeneratedValue
    private Integer colourID;
    private String colour;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "colour")
    private Collection<Wine> wines;
}