package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.useCase.actions.EditRailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditRailRouter {

    @Bean
    public RouterFunction<ServerResponse> editRail(EditRailUseCase editRailUseCase) {
        return route(PUT("/editRail").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RailDTO.class)
                        .flatMap(railDTO -> editRailUseCase.apply(railDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
