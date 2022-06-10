package com.sofkau.don_rauls_hardware_store.routes;

import com.sofkau.don_rauls_hardware_store.collection.Provider;
import com.sofkau.don_rauls_hardware_store.model.ProviderDto;
import com.sofkau.don_rauls_hardware_store.usecases.GetAllProvidersUseCase;
import com.sofkau.don_rauls_hardware_store.usecases.PostProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;


@Configuration
public class ProviderRoutes {

    @Bean
    public RouterFunction<ServerResponse> getAllProviders(GetAllProvidersUseCase getAllProvidersUseCase) {
        return route(GET("/api/v1/provider"), request ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllProvidersUseCase.get(), ProviderDto.class)));
    }


    @Bean
    public RouterFunction<ServerResponse> postProvider(PostProviderUseCase postProviderUseCase) {
        return route(POST("/api/v1/provider"), request -> request.bodyToMono(ProviderDto.class)
                .flatMap(provider -> postProviderUseCase.apply(provider))
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(result)));
    }
}
