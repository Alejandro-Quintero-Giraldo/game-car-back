package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.CarDTO;
import co.com.demo.carsgame.mapper.CarMapper;
import co.com.demo.carsgame.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Validated
public class GetCarByDriverIdUseCase {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public GetCarByDriverIdUseCase(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Flux<CarDTO> findCarsByDriverId(String id){
        return carRepository.findByDriverId(id)
                .flatMap(
                        car -> Flux.just(carMapper.mappertoCarDTO().apply(car))
                );
    }
}
