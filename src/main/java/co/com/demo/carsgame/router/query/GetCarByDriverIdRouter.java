package co.com.demo.carsgame.router.query;

import co.com.demo.carsgame.dto.CarDTO;
import co.com.demo.carsgame.useCase.queries.GetCarByDriverIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCarByDriverIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findCarByDriverId(GetCarByDriverIdUseCase findCarsByDriverIdUseCase){
        return route(GET("/car/driver/{driverId}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findCarsByDriverIdUseCase.findCarsByDriverId(request.pathVariable("gameid")), CarDTO.class))
        );
    }
}
