package co.com.demo.carsgame.router.query;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.useCase.actions.EditRailUseCase;
import co.com.demo.carsgame.useCase.queries.FindByIdRailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindByIdRailRouter {


    @Bean
    public RouterFunction<ServerResponse> getfindbyidrail(FindByIdRailUseCase findByIdRailUseCase){
        return route(GET("/rail/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(findByIdRailUseCase.getfindbyid(request.pathVariable("id")), RailDTO.class)
        );
    }
}
