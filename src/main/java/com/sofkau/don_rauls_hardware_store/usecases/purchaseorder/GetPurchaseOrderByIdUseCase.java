package com.sofkau.don_rauls_hardware_store.usecases.purchaseorder;

import com.sofkau.don_rauls_hardware_store.mapper.PurchaseOrderMapper;
import com.sofkau.don_rauls_hardware_store.model.PurchaseOrderDto;
import com.sofkau.don_rauls_hardware_store.repository.IPurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetPurchaseOrderByIdUseCase implements Function<String, Mono<PurchaseOrderDto>> {

    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public Mono<PurchaseOrderDto> apply(String id) {
        return purchaseOrderRepository
                .findById(id)
                .map(entity -> purchaseOrderMapper.fromEntityToDto().apply(entity));    }
}
