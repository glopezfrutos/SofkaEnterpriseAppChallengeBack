package com.sofkau.don_rauls_hardware_store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductInInvoice {
    private String name;
    private Integer quantity;
    private Double price;
}
