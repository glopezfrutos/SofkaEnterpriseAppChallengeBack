package com.sofkau.don_rauls_hardware_store.usecases.product;

import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest
class PostProductUseCaseTest {

    @MockBean
    PostProductUseCase useCase;

    @Test
    void testPostProductUseCase() {
        ProductDto productDto = new ProductDto("123abc","Hammer", 5, 5, 10, 10.5, true);

        StepVerifier
                .create(Mono.just(Mockito.when(useCase.apply(productDto)).thenReturn(Mono.just(productDto))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

}