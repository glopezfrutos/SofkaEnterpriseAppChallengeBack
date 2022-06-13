package com.sofkau.don_rauls_hardware_store.usecases.purchaseorder;

import com.sofkau.don_rauls_hardware_store.mapper.InvoiceMapper;
import com.sofkau.don_rauls_hardware_store.mapper.PurchaseOrderMapper;
import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.model.PurchaseOrderDto;
import com.sofkau.don_rauls_hardware_store.repository.IInvoiceRepository;
import com.sofkau.don_rauls_hardware_store.repository.IPurchaseOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class PostPurchaseOrderUseCase implements Function<PurchaseOrderDto, Mono<PurchaseOrderDto>> {

    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public Mono<PurchaseOrderDto> apply(PurchaseOrderDto purchaseOrderDto) {
        return purchaseOrderRepository
                .save(purchaseOrderMapper
                        .fromDtoToEntity()
                        .apply(purchaseOrderDto))
                .map(entity -> purchaseOrderMapper.fromEntityToDto().apply(entity));
    }
}
