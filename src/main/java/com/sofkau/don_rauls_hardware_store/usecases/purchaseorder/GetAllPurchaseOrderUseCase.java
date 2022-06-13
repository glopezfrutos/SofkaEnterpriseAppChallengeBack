package com.sofkau.don_rauls_hardware_store.usecases.purchaseorder;

import com.sofkau.don_rauls_hardware_store.mapper.PurchaseOrderMapper;
import com.sofkau.don_rauls_hardware_store.model.PurchaseOrderDto;
import com.sofkau.don_rauls_hardware_store.repository.IPurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllPurchaseOrderUseCase implements Supplier<Flux<PurchaseOrderDto>> {

    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public Flux<PurchaseOrderDto> get() {
        return purchaseOrderRepository
                .findAll()
                .map(entity -> purchaseOrderMapper.fromEntityToDto().apply(entity));
    }
}
