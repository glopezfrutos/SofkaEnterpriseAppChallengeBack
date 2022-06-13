package com.sofkau.don_rauls_hardware_store.routes;

import com.sofkau.don_rauls_hardware_store.model.PurchaseOrderDto;
import com.sofkau.don_rauls_hardware_store.usecases.purchaseorder.GetAllPurchaseOrderUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.purchaseorder.PostPurchaseOrderUseCase;
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
public class PurchaseOrderRoutes {

    @Bean
    public RouterFunction<ServerResponse> getAllPurchaseOrders(GetAllPurchaseOrderUseCase getAllPurchaseOrderUseCase) {
        return route(GET("/api/v1/order"), request ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllPurchaseOrderUseCase.get(), PurchaseOrderDto.class)));
    }


    @Bean
    public RouterFunction<ServerResponse> postPurchaseOrder(PostPurchaseOrderUseCase postPurchaseOrderUseCase) {
        return route(POST("/api/v1/order"), request -> request.bodyToMono(PurchaseOrderDto.class)
                .flatMap(postPurchaseOrderUseCase)
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(result)));
    }
}
