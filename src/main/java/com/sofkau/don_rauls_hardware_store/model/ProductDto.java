package com.sofkau.don_rauls_hardware_store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private Integer stockQuantity;
    private Integer min;
    private Integer max;
    private Double price;
    private boolean isActive;
}
