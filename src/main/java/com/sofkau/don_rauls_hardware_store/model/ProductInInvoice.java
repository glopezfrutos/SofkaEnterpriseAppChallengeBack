package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

@Data
public class ProductInInvoice {
    private String name;
    private Long quantity;
    private Long price;
}
