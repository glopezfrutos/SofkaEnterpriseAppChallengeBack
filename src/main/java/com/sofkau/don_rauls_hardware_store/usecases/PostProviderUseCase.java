package com.sofkau.don_rauls_hardware_store.usecases;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.mapper.ProviderMapper;
import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import com.sofkau.don_rauls_hardware_store.repository.IProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class PostProviderUseCase implements Function<ProviderDto, Mono<ProviderDto>> {

    private final IProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public PostProviderUseCase(IProviderRepository providerRepository, ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }
    @Override
    public Mono<ProviderDto> apply(ProviderDto providerDto) {
        return providerRepository
                .save(providerMapper
                        .fromDtoToEntity()
                        .apply(providerDto))
                .map(entity -> providerMapper.fromEntityToDto().apply(entity));
    }
}
