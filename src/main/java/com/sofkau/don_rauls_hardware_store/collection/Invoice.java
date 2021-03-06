package com.sofkau.don_rauls_hardware_store.collection;

import com.sofkau.don_rauls_hardware_store.model.ProductInDocumentDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document
@Data
public class Invoice {

    @Id
    private String id;
    private Long invoiceNumber;
    private String date;
    private String clientName;
    private String seller;
    private Set<ProductInDocumentDto> products;
    private Double total;
}
