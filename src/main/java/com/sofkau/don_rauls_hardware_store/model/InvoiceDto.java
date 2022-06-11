package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class InvoiceDto {
    private String id;
    private Long invoiceNumber;
    private Date date = new Date();
    private String clientName;
    private String seller;
    private Set<ProductInInvoice> products;
    private Double total;
}
