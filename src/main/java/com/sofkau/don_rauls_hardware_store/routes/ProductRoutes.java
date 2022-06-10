package com.sofkau.don_rauls_hardware_store.routes;

import com.sofkau.don_rauls_hardware_store.model.ProductDto;
import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import com.sofkau.don_rauls_hardware_store.usecases.GetAllProductsUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.GetAllProvidersUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.PostProductUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.PostProviderUseCase;
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
public class ProductRoutes {

    @Bean
    public RouterFunction<ServerResponse> getAllProducts(GetAllProductsUseCase getAllProductsUseCase) {
        return route(GET("/api/v1/product"), request ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllProductsUseCase.get(), ProductDto.class)));
    }


    @Bean
    public RouterFunction<ServerResponse> postProduct(PostProductUseCase postProductUseCase) {
        return route(POST("/api/v1/product"), request -> request.bodyToMono(ProductDto.class)
                .flatMap(postProductUseCase)
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(result)));
    }
}
