package com.sofkau.don_rauls_hardware_store.routes;

import com.sofkau.don_rauls_hardware_store.model.InvoiceDto;
import com.sofkau.don_rauls_hardware_store.usecases.invoices.GetAllInvoicesUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.invoices.PostInvoiceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class InvoiceRoutes {

    @Bean
    public RouterFunction<ServerResponse> getAllInvoices(GetAllInvoicesUseCase getAllInvoicesUseCase) {
        return route(GET("/api/v1/invoice"), request ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllInvoicesUseCase.get(), InvoiceDto.class)));
    }


    @Bean
    public RouterFunction<ServerResponse> postInvoice(PostInvoiceUseCase postInvoiceUseCase) {
        return route(POST("/api/v1/invoice"), request -> request.bodyToMono(InvoiceDto.class)
                .flatMap(postInvoiceUseCase)
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(result)));
    }
}
