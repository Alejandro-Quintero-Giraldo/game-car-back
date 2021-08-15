package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.useCase.actions.StartGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StartGameRouter {

    @Bean
    public RouterFunction<ServerResponse> startGame(StartGameUseCase startGameUseCase){
        return route(POST("/game/start/{gameid}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                startGameUseCase.StartGame(
                                        request.pathVariable("gameid")), String.class))
                );
    }
}
