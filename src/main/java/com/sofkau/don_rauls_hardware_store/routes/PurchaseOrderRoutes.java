package com.sofkau.don_rauls_hardware_store.routes;

import com.sofkau.don_rauls_hardware_store.collection.PurchaseOrder;
import com.sofkau.don_rauls_hardware_store.model.PurchaseOrderDto;
import com.sofkau.don_rauls_hardware_store.usecases.purchaseorder.GetAllPurchaseOrderUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.purchaseorder.PostPurchaseOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class PurchaseOrderRoutes {

    @Bean
//    @RouterOperation(path = "/api/v1/order", produces = {
//            MediaType.APPLICATION_JSON_VALUE},
//            beanClass = GetAllPurchaseOrderUseCase.class, method = RequestMethod.GET, beanMethod = "get",
//            operation = @Operation(operationId = "getOrders", responses = {
//                    @ApiResponse(responseCode = "200", description = "Successful operation",
//                            content = @Content(schema = @Schema(implementation = PurchaseOrder.class)))}
//            ))
    public RouterFunction<ServerResponse> getAllPurchaseOrders(GetAllPurchaseOrderUseCase getAllPurchaseOrderUseCase) {
        return route(GET("/api/v1/order"), request ->
                ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllPurchaseOrderUseCase.get(), PurchaseOrderDto.class)));
    }



    @Bean
    @RouterOperation(path = "/api/v1/order", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = PostPurchaseOrderUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createOrder", responses = {
                    @ApiResponse(responseCode = "201", description = "Successful operation", content = @Content(schema = @Schema(implementation = PurchaseOrder.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid Purchase Order details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = PurchaseOrder.class)))
            ))
    public RouterFunction<ServerResponse> postPurchaseOrder(PostPurchaseOrderUseCase postPurchaseOrderUseCase) {
        return route(POST("/api/v1/order"), request -> request.bodyToMono(PurchaseOrderDto.class)
                .flatMap(postPurchaseOrderUseCase)
                .flatMap(result -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result)
                )
                .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
