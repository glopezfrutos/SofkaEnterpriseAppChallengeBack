package com.sofkau.don_rauls_hardware_store.usecases.product;

import com.sofkau.don_rauls_hardware_store.mapper.ProductMapper;
import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import com.sofkau.don_rauls_hardware_store.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class PostProductUseCase implements Function<ProductDto, Mono<ProductDto>> {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    public PostProductUseCase(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ProductDto> apply(ProductDto productDto) {
        return productRepository
                .save(productMapper
                        .fromDtoToEntity()
                        .apply(productDto))
                .map(entity -> productMapper.fromEntityToDto().apply(entity));
    }
}
