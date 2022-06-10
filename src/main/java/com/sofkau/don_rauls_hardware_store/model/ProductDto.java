package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String name;
    private Long quantity;
    private Long min;
    private Long max;
    private boolean isActive;
}
