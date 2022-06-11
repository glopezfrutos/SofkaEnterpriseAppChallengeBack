package com.sofkau.don_rauls_hardware_store.mapper;

import com.sofkau.don_rauls_hardware_store.collection.Invoice;
import com.sofkau.don_rauls_hardware_store.collection.Product;
import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class InvoiceMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Function<Invoice, InvoiceDto> fromEntityToDto(){
        return entity -> modelMapper.map(entity, InvoiceDto.class);
    }

    public Function<InvoiceDto, Invoice> fromDtoToEntity(){
        return dto -> modelMapper.map(dto, Invoice.class);
    }
}
