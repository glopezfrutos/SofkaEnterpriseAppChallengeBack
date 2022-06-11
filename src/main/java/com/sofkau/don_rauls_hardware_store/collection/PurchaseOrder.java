package com.sofkau.don_rauls_hardware_store.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document
@Data
public class PurchaseOrder {

    @Id
    private String id;

    private Long orderNumber;

    private Date date;

    private Provider provider;

    private Set<Product> products;

    private Long total;
}
