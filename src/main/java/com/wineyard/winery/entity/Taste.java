package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tastes")
@Setter
@Getter
public class Taste
{
    @Id
    @GeneratedValue
    private Integer tasteID;
    private String taste;

    @OneToMany(mappedBy = "taste")
    private List<Wine> wines;
}