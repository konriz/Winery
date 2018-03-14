package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grapes")
@Getter
@Setter
public class Grapes {

    @Id
    @GeneratedValue
    private Integer grapesID;
    private String grapes;

    public Grapes(){}

    public Grapes(String grapes)
    {
        this.grapes = grapes;
    }

}
