package com.sofkau.don_rauls_hardware_store.mapper;

import com.sofkau.don_rauls_hardware_store.collection.Product;
import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Function<Product, ProductDto> fromEntityToDto(){
        return entity -> modelMapper.map(entity, ProductDto.class);
    }

    public Function<ProductDto, Product> fromDtoToEntity(){
        return dto -> modelMapper.map(dto, Product.class);
    }
}
