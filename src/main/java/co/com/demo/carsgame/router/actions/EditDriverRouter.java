package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.DriverDTO;
import co.com.demo.carsgame.useCase.actions.EditDriverUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditDriverRouter {

    @Bean
    public RouterFunction<ServerResponse> modifyDriver(EditDriverUseCase editDriverUseCase){
        return route(PUT("/driver/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DriverDTO.class)
                        .flatMap(driverDTO -> editDriverUseCase.modifyDriver(driverDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}
