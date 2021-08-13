package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Car;
import co.com.demo.carsgame.domain.game.values.Advance;
import co.com.demo.carsgame.domain.game.values.CurrentPosition;
import co.com.demo.carsgame.domain.game.values.IsArrivedGoal;
import co.com.demo.carsgame.domain.game.values.id.*;
import co.com.demo.carsgame.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarMapper {

    public Function<CarDTO, Car> mapperToCar(String id){
        return updateCar -> new Car(
                    CarId.of(id),
                    new IsArrivedGoal(updateCar.getIsArrivedGoal()),
                    new CurrentPosition(updateCar.getCurrentPosition()),
                    new Advance(updateCar.getAdvance()),
                    DriverId.of(updateCar.getDriverId()),
                    GameId.of(updateCar.getGameId()),
                    RailId.of(updateCar.getRailId())
            );

        }

    public Function<Car, CarDTO> mappertoDTO(){
        return car -> new CarDTO(
                car.getId().getValue(),
                car.getIsArrivedGoal().getValue(),
                car.getCurrentPosition().getValue(),
                car.getAdvance().getValue(),
                car.getDriverId().getValue(),
                car.getGameId().getValue(),
                car.getRailId().getValue()
        );
    }

}
