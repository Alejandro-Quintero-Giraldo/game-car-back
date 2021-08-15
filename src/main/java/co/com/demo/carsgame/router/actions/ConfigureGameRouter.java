package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.useCase.actions.ConfigureGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.ArrayList;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConfigureGameRouter {

    @Bean
    public RouterFunction<ServerResponse> configurateGame(ConfigureGameUseCase configureGameUseCase){
        return route(POST("/game/configurate/{trackDistance}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ArrayList.class)
                        .flatMap(
                                arrayList -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(BodyInserters.fromPublisher(configureGameUseCase.configureGame(arrayList,request.pathVariable("trackDistance")), String.class))
                                        )
                        );
    }
}
