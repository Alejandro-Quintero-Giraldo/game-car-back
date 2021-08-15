package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.useCase.actions.CreateRailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateRailRouter {
/*
    @Bean
    public RouterFunction<ServerResponse> createRail(CreateRailUseCase createRailUseCase) {
        return route(POST("/rail/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RailDTO.class)
                        .flatMap(railDTO -> createRailUseCase.createRail(railDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }*/
}
