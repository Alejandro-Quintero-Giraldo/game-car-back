package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.CarDTO;
import co.com.demo.carsgame.mapper.CarMapper;
import co.com.demo.carsgame.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateCarUseCase {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CreateCarUseCase(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public void  createCar(CarDTO carDTO) {
         carRepository
                .save(carMapper.mapperToCar(carDTO.getId())
                        .apply(carDTO))
                .subscribe();
    }
}
