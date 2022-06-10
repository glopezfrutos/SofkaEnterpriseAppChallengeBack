package com.sofkau.don_rauls_hardware_store.usecases;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.mapper.ProviderMapper;
import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import com.sofkau.don_rauls_hardware_store.repository.IProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllProvidersUseCase implements Supplier<Flux<ProviderDto>> {

    private final IProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Override
    public Flux<ProviderDto> get() {
        return providerRepository
                .findAll()
                .map(entity -> providerMapper.fromEntityToDto().apply(entity));
    }
}
