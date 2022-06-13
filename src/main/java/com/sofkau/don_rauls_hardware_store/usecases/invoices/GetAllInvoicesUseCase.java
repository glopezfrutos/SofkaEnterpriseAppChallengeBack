package com.sofkau.don_rauls_hardware_store.usecases.invoices;

import com.sofkau.don_rauls_hardware_store.mapper.InvoiceMapper;
import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.repository.IInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllInvoicesUseCase implements Supplier<Flux<InvoiceDto>> {

    private final IInvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public Flux<InvoiceDto> get() {
        return invoiceRepository
                .findAll()
                .map(entity -> invoiceMapper.fromEntityToDto().apply(entity));
    }
}
