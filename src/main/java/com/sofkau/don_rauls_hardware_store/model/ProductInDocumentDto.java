package com.sofkau.don_rauls_hardware_store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductInDocumentDto {
    private String id;
    private String name;
    private Integer quantity;
    private Double price;
}
