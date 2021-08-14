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
public class EditCarUseCase {


    private final CarRepository carRepository;
    private final CarMapper carMapperc;

    @Autowired
    public EditCarUseCase(CarRepository carRepository, CarMapper carMapperc) {
        this.carRepository = carRepository;
        this.carMapperc = carMapperc;
    }

    public Mono<CarDTO> modifyCar(CarDTO carDTO){
        return
                carRepository.save(carDTO)
                        .thenReturn(carDTO);
    }
}
