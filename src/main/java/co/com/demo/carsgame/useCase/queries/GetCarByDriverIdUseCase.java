package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.CarDTO;
import co.com.demo.carsgame.dto.DriverDTO;
import co.com.demo.carsgame.repository.CarRepository;
import co.com.demo.carsgame.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetCarByDriverIdUseCase {

    private final CarRepository carRepository;

    @Autowired
    public GetCarByDriverIdUseCase(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Flux<CarDTO> findCarsByDriverId(String id){
        return carRepository.findByDriverId(id);
    }
}
