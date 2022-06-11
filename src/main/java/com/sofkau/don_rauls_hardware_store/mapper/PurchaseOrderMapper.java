package com.sofkau.don_rauls_hardware_store.mapper;

import com.sofkau.don_rauls_hardware_store.collection.Invoice;
import com.sofkau.don_rauls_hardware_store.collection.PurchaseOrder;
import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.model.PurchaseOrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PurchaseOrderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Function<PurchaseOrder, PurchaseOrderDto> fromEntityToDto(){
        return entity -> modelMapper.map(entity, PurchaseOrderDto.class);
    }

    public Function<PurchaseOrderDto, PurchaseOrder> fromDtoToEntity(){
        return dto -> modelMapper.map(dto, PurchaseOrder.class);
    }
}
