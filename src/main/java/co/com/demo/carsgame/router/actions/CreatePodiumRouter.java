package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.PodiumDTO;
import co.com.demo.carsgame.useCase.actions.CreatePodiumUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreatePodiumRouter {

    @Bean
    public RouterFunction<ServerResponse> createPodium(CreatePodiumUseCase createPodiumUseCase){
        return route(POST("/podium/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PodiumDTO.class).flatMap(podiumDTO -> createPodiumUseCase.apply(podiumDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)
                        )
                )
        );
    }
}
