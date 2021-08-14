package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.GameDTO;
import co.com.demo.carsgame.useCase.actions.CreateGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateGameRouter {

    @Bean
    public RouterFunction<ServerResponse> createGame(CreateGameUseCase createGameUseCase){
        return  route(POST("createGame").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(GameDTO.class)
                        .flatMap(gameDTO -> createGameUseCase.createGame(gameDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
                );
    }
}
