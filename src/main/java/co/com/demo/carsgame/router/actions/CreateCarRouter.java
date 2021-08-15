package co.com.demo.carsgame.router.actions;

import co.com.demo.carsgame.dto.CarDTO;
import co.com.demo.carsgame.useCase.actions.CreateCarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class CreateCarRouter {
/*
    @Bean
    public RouterFunction<ServerResponse> CreateCarRouter(CreateCarUseCase createCarUseCase){
        return  route(POST("/car/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CarDTO.class)
                        .flatMap(carDTO -> createCarUseCase.createCar(carDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }*/
}
