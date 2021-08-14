package co.com.demo.carsgame.router.query;

import co.com.demo.carsgame.dto.TrackDTO;
import co.com.demo.carsgame.useCase.queries.FindByIdTrackUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindByIdTrackRouter {

    @Bean
    public RouterFunction<ServerResponse> getfindbyidtrack(FindByIdTrackUseCase findByIdTrackUseCase){
        return route(GET("findTrackById/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(findByIdTrackUseCase.getfindbyid(request.pathVariable("id")), TrackDTO.class)
        );
    }
}