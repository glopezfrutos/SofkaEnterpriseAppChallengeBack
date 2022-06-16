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
        Provider provider1 = new Provider();
        provider1.setId("123abc");
        provider1.setName("John Lennon");
        provider1.setAddress("1st Street 123");
        provider1.setEMail("John@lennon.com");
        provider1.setPhone("1-123-456");
        provider1.setActive(true);

        Provider provider2 = new Provider();
        provider2.setId("234bcd");
        provider2.setName("Paul McCartney");
        provider2.setAddress("2st Street 234");
        provider2.setEMail("paul@mccartney.com");
        provider2.setPhone("1-123-456");
        provider2.setActive(true);


        Mockito.when(repository.findAll()).thenReturn(Flux.just(provider1, provider2));
        Flux<ProviderDto> providerDtoFlux = useCase.get();

        StepVerifier.create(providerDtoFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }

}