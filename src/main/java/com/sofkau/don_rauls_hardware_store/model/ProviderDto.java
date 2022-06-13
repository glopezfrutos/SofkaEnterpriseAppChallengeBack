package com.sofkau.don_rauls_hardware_store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto {
    private String id;
    private String name;
    private String address;
    private String eMail;
    private String phone;
    private boolean isActive;
}
