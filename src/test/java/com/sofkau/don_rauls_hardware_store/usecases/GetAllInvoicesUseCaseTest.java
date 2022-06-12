package com.sofkau.don_rauls_hardware_store.usecases;

import com.sofkau.don_rauls_hardware_store.collection.Invoice;
import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.model.ProductInInvoice;
import com.sofkau.don_rauls_hardware_store.repository.IInvoiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;

@SpringBootTest
class GetAllInvoicesUseCaseTest {

    @MockBean
    private IInvoiceRepository invoiceRepository;

    @Autowired
    private GetAllInvoicesUseCase getAllInvoicesUseCase;

    @Test
    @DisplayName("Test find all invoices")
    public void getAllInvoicesUseCase() {
        Set<ProductInInvoice> productsA = new HashSet<ProductInInvoice>();
        ProductInInvoice productA1 = new ProductInInvoice("Hammer", 5, 10.5);
        productsA.add(productA1);
        Invoice invoice1 = new Invoice("1", 1L, new Date(), "John", "Wilson", productsA, 52.5);

        Set<ProductInInvoice> productsB = new HashSet<ProductInInvoice>();
        ProductInInvoice productB1 = new ProductInInvoice("Drill", 1, 11.5);
        productsB.add(productB1);
        Invoice invoice2 = new Invoice("2", 2L, new Date(), "William", "Peter", productsB, 11.5);

        Mockito.when(invoiceRepository.findAll()).thenReturn(Flux.just(invoice1, invoice2));

        Flux<InvoiceDto> publisher = getAllInvoicesUseCase.get();

        StepVerifier.create(Flux.just(invoice1, invoice2))
                .expectNext(invoice1, invoice2)
                .verifyComplete();
    }
}