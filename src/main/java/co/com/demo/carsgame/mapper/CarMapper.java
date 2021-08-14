package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Car;
import co.com.demo.carsgame.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarMapper {

    public Function<CarDTO, Car> mapperToCar(String id) {
        return updateCar -> {
            Car car = new Car();
            car.setId(updateCar.getId());
            car.setIsArrivedGoal(updateCar.getIsArrivedGoal());
            car.setCurrentPosition(updateCar.getCurrentPosition());
            car.setAdvance(updateCar.getAdvance());
            car.setDriverId(updateCar.getDriverId());
            car.setGameId(updateCar.getGameId());
            car.setRailId(updateCar.getRailId());
            return car;
        };

    }

    public Function<Car, CarDTO> mappertoCarDTO(){
        return car -> new CarDTO(
                car.getId(),
                car.getIsArrivedGoal(),
                car.getCurrentPosition(),
                car.getAdvance(),
                car.getDriverId(),
                car.getGameId(),
                car.getRailId()
        );
    }

}
