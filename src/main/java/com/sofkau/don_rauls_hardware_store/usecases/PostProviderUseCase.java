package com.sofkau.don_rauls_hardware_store.usecases;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class PostProviderUseCase implements Function<Provider, Mono<Provider>> {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Mono<Provider> apply(Provider providerMono) {
        return providerRepository.save(providerMono);
    }
}
