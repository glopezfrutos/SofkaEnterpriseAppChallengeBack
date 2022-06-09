package com.sofkau.don_rauls_hardware_store.repository;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends ReactiveMongoRepository<Provider, String> {
}
