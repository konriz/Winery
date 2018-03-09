package com.wineyard.winery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue
    @Column(name = "brandID")
    private Integer brandID;
    private String brand;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Wine> wines;

    private Brand() {}

    public Brand(final String brand)
    {
        this.brand = brand;
    }

}
