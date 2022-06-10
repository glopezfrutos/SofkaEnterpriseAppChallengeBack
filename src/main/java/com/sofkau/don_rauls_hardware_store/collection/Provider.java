package com.sofkau.don_rauls_hardware_store.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Provider {

    @Id
    private String id;

    private String name;

    private String address;

    private String eMail;

    private String phone;

    private boolean isActive;
}
