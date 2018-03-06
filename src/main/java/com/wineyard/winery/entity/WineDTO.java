package com.wineyard.winery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WineDTO {
    private String name;
    private String taste;
    private String colour;
    private String brand;
}
