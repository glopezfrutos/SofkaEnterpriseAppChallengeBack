package com.sofkau.don_rauls_hardware_store.usecases;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllProvidersUseCase implements Supplier<Flux<Provider>> {

    private final ProviderRepository providerRepository;

    @Override
    public Flux<Provider> get() {
        return providerRepository.findAll();
    }
}
