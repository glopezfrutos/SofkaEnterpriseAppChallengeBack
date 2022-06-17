package com.sofkau.don_rauls_hardware_store.routes;

import com.sofkau.don_rauls_hardware_store.collection.Product;
import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import com.sofkau.don_rauls_hardware_store.usecases.product.GetAllProductsUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.product.PostProductUseCase;
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
public class ProductRoutes {
    @Bean
    @RouterOperation(path = "/api/v1/product", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetAllProductsUseCase.class, method = RequestMethod.GET, beanMethod = "get",
            operation = @Operation(operationId = "getProducts", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = Product.class)))}
            ))
    public RouterFunction<ServerResponse> getAllProducts(GetAllProductsUseCase getAllProductsUseCase) {
        return route(GET("/api/v1/product"), request ->
                ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllProductsUseCase.get(), ProductDto.class)));
    }


    @Bean
    @RouterOperation(path = "/api/v1/product", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = PostProductUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createProduct", responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid Recipe details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Product.class)))
            ))
    public RouterFunction<ServerResponse> postProduct(PostProductUseCase postProductUseCase) {
        return route(POST("/api/v1/product"), request -> request.bodyToMono(ProductDto.class)
                .flatMap(postProductUseCase)
                .flatMap(result -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result)
                        )
                .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }


}
