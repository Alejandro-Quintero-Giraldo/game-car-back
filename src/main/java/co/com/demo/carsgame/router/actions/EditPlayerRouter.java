package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.useCase.actions.EditPlayerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class EditPlayerRouter {
/*
    @Bean
    public RouterFunction<ServerResponse> modifyPlayer(EditPlayerUseCase editPlayerUseCase){
        return route(PUT("/player/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PlayerDTO.class)
                        .flatMap(playerDTO -> editPlayerUseCase.modifyPlayer(playerDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }*/
}
