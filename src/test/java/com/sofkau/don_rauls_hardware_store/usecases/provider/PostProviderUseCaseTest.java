package com.sofkau.don_rauls_hardware_store.usecases.provider;

import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class PostProviderUseCaseTest {
    @MockBean
    PostProviderUseCase useCase;

    @Test
    void testPostProviderUseCase() {
        ProviderDto providerDto = new ProviderDto("123abc","John Lennon", "1st Street 123", "John@lennon.com", "1-123-456", true);

        StepVerifier
                .create(Mono.just(Mockito.when(useCase.apply(providerDto)).thenReturn(Mono.just(providerDto))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}