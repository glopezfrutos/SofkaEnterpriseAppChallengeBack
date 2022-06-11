package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class PurchaseOrderDto {
    private String id;
    private Long orderNumber;
    private Date date = new Date();
    private String providerId;
    private String providerName;
    private Set<ProductInInvoice> products;
}
