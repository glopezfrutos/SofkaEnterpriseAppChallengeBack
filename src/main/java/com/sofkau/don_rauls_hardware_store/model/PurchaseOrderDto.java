package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class PurchaseOrderDto {
    private String id;
    private Long orderNumber;
    private String date = LocalDate.now().toString();
    private String providerId;
    private String providerName;
    private Set<ProductInDocumentDto> products;
}
