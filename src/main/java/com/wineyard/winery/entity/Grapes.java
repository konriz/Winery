package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grapes")
@Getter
@Setter
public class Grapes {

    @Id
    @GeneratedValue
    private int grapeID;
    private String grapes;

}
