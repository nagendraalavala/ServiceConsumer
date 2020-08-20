package com.example.retailservice.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity
{
    private Long id;

    private String name;
    private double cost;
    private String stock;

    public ProductEntity(String s) {
    }
}
