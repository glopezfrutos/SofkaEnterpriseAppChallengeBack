package com.sofkau.don_rauls_hardware_store.model;

import com.sofkau.don_rauls_hardware_store.collection.Product;
import com.sofkau.don_rauls_hardware_store.collection.Provider;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class PurchaseOrderDto {
    private String id;
    private Long orderNumber;
    private Date date;
    private Provider provider;
    private Set<Product> products;
    private Long total;
}
