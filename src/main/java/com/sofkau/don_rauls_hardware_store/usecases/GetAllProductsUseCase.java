package com.sofkau.don_rauls_hardware_store.usecases;

import com.sofkau.don_rauls_hardware_store.mapper.ProductMapper;
import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import com.sofkau.don_rauls_hardware_store.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllProductsUseCase implements Supplier<Flux<ProductDto>> {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDto> get() {
        return productRepository
                .findAll()
                .map(entity -> productMapper.fromEntityToDto().apply(entity));
    }
}
