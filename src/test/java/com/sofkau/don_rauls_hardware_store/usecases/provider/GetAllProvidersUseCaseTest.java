package com.sofkau.don_rauls_hardware_store.usecases.provider;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.mapper.ProviderMapper;
import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import com.sofkau.don_rauls_hardware_store.repository.IProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProvidersUseCaseTest {

    private GetAllProvidersUseCase useCase;

    @Autowired
    private ProviderMapper mapper;

    @Mock
    IProviderRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new GetAllProvidersUseCase(repository, mapper);
    }

    @Test
    void testAllGetAllProvidersUseCase() {
        Provider provider1 = new Provider("123abc","John Lennon", "1st Street 123", "John@lennon.com", "1-123-456", true);
        Provider provider2 = new Provider("123abc","Paul McCartney", "2st Street 234", "paul@mccartney.com", "1-123-456", true);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(provider1, provider2));
        Flux<ProviderDto> providerDtoFlux = useCase.get();

        StepVerifier.create(providerDtoFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }

}