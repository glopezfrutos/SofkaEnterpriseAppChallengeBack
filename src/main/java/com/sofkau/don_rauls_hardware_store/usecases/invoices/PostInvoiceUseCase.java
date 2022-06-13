package com.sofkau.don_rauls_hardware_store.usecases.invoices;

import com.sofkau.don_rauls_hardware_store.mapper.InvoiceMapper;
import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.repository.IInvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class PostInvoiceUseCase implements Function<InvoiceDto, Mono<InvoiceDto>> {

    private final IInvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public Mono<InvoiceDto> apply(InvoiceDto invoiceDto) {
        return invoiceRepository
                .save(invoiceMapper
                        .fromDtoToEntity()
                        .apply(invoiceDto))
                .map(entity -> invoiceMapper.fromEntityToDto().apply(entity));
    }
}
