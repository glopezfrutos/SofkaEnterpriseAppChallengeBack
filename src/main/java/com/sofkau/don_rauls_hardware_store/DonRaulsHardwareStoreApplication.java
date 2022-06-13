package com.sofkau.don_rauls_hardware_store;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Don Raul's Hardware Store API", version = "1.0.0", description = "Documentation APIs v1.0.0"))
public class DonRaulsHardwareStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonRaulsHardwareStoreApplication.class, args);
	}

}
