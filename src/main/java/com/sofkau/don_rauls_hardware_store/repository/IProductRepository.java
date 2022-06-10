package com.sofkau.don_rauls_hardware_store.repository;

import com.sofkau.don_rauls_hardware_store.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
