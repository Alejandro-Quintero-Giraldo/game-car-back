package co.com.demo.carsgame.router.query;

import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.useCase.queries.GetPlayersByGameIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetPlayersByGameIdRouter {

    @Bean
    public RouterFunction<ServerResponse> getPlayersByGameId(GetPlayersByGameIdUseCase getPlayersByGameIdUseCase){
        return route(GET("/get/players/game/id/{gameid}").and(accept(MediaType.TEXT_PLAIN)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getPlayersByGameIdUseCase.getPlayersByGameId(request.pathVariable("gameid")), PlayerDTO.class))
                );
    }
}