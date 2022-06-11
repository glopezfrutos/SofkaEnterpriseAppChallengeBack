package com.sofkau.don_rauls_hardware_store.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {

    @Id
    private String id;

    private String name;

    private Long quantity;

    private Long min;

    private Long max;

    private Long price;

    private boolean isActive;
}
