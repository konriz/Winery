package com.wineyard.winery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

//public enum Taste {
//
//    NONE, DRY, MEDIUM_DRY, MEDIUM_SWEET, SWEET;
//
//}
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taste")
    private Collection<Wine> wines;
}