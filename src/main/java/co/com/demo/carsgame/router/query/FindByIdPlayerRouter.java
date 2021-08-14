package co.com.demo.carsgame.router.query;

import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.useCase.queries.FindByIdPlayerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
@Validated
public class FindByIdPlayerRouter {

    @Bean
    public RouterFunction<ServerResponse> findByIdPlayer(FindByIdPlayerUseCase findByIdPlayerUseCase){
        return route(GET("/player/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findByIdPlayerUseCase.findById(request.pathVariable("id")), PlayerDTO.class))
        );
    }
}
