package co.com.demo.carsgame.router.query;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.useCase.queries.FindRailsByTrackIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindRailByTrackIdRouter {

    @Bean
    public RouterFunction<ServerResponse> getRailByTrackId(FindRailsByTrackIdUseCase findRailsByTrackIdUseCase){
        return route(GET("/get/rail/track/id/{trackid}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findRailsByTrackIdUseCase.getRailByTrackId(request.pathVariable("trackid")), RailDTO.class))
        );
    }
}
