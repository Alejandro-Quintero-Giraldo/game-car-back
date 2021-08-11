package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Car;
import co.com.demo.carsgame.domain.game.values.IsArrivedGoal;
import co.com.demo.carsgame.domain.game.values.id.CarId;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PlayerId;
import co.com.demo.carsgame.domain.game.values.id.RailId;
import co.com.demo.carsgame.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarMapper {

    public Function<CarDTO, Car> mapperToCar(String id){
        return updateCar -> new Car(
                    CarId.of(id),
                    new IsArrivedGoal(updateCar.getIsArrivedGoal()),
                    PlayerId.of(updateCar.getPlayerId()),
                    GameId.of(updateCar.getGameId()),
                    RailId.of(updateCar.getRailId())
            );

        }

    public Function<Car, CarDTO> mappertoDTO(){
        return car -> new CarDTO(
                car.getId().getValue(),
                car.getIsArrivedGoal().getValue(),
                car.getPlayerId().getValue(),
                car.getGameId().getValue(),
                car.getRailId().getValue()
        );
    }

}
