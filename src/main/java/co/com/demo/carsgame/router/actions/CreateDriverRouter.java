package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.DriverDTO;
import co.com.demo.carsgame.useCase.actions.CreateDriverUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateDriverRouter {

    @Bean
    public RouterFunction<ServerResponse> createDriver(CreateDriverUseCase createDriverUseCase){
        return  route(POST("/create/driver").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DriverDTO.class)
                        .flatMap(driverDTO -> createDriverUseCase.apply(driverDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
