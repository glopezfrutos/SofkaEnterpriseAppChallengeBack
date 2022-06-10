package com.sofkau.don_rauls_hardware_store.mapper;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProviderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Function<Provider, ProviderDto> fromEntityToDto(){
        return entity -> modelMapper.map(entity, ProviderDto.class);
    }

    public Function<ProviderDto, Provider> fromDtoToEntity(){
        return dto -> modelMapper.map(dto, Provider.class);
    }
}
