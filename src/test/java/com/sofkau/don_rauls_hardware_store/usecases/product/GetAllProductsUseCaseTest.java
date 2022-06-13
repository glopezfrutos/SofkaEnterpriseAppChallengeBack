package com.sofkau.don_rauls_hardware_store.usecases.product;

import com.sofkau.don_rauls_hardware_store.collection.Product;
import com.sofkau.don_rauls_hardware_store.mapper.ProductMapper;
import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import com.sofkau.don_rauls_hardware_store.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProductsUseCaseTest {

    private GetAllProductsUseCase useCase;

    @Autowired
    private ProductMapper mapper;

    @Mock
    IProductRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new GetAllProductsUseCase(repository, mapper);
    }

    @Test
    void testAllProductsUseCase() {
        Product product1 = new Product("123abc","Hammer", 5, 5, 10, 10.5, true);
        Product product2 = new Product("234bcd","Drill", 1, 1, 100, 100.0, true);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(product1, product2));
        Flux<ProductDto> productDtoFlux = useCase.get();

        StepVerifier.create(productDtoFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }
}