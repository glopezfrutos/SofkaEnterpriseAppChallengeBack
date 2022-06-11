package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String name;
    private Long stockQuantity;
    private Long min;
    private Long max;
    private Long price;
    private boolean isActive;
}
