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
        Product product1 = new Product();
        product1.setId("123abc");
        product1.setName("Hammer");
        product1.setStockQuantity(5);
        product1.setMin(5);
        product1.setMax(10);
        product1.setPrice(10.5);
        product1.setActive(true);

        Product product2 = new Product();
        product2.setId("234bcd");
        product2.setName("Drill");
        product2.setStockQuantity(1);
        product2.setMin(1);
        product2.setMax(100);
        product2.setPrice(100.0);
        product2.setActive(true);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(product1, product2));
        Flux<ProductDto> productDtoFlux = useCase.get();

        StepVerifier.create(productDtoFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }
}