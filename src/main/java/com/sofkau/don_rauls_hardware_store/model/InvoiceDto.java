package com.sofkau.don_rauls_hardware_store.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class InvoiceDto {
    private String id;
    private Long invoiceNumber;
    private String date = LocalDate.now().toString();
    private String clientName;
    private String seller;
    private Set<ProductInDocumentDto> products;
    private Double total;
}
