package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Driver;
import co.com.demo.carsgame.domain.game.values.Position;
import co.com.demo.carsgame.domain.game.values.id.*;
import co.com.demo.carsgame.dto.DriverDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DriverMapper {


    public Function<DriverDTO, Driver> mapperToDriver(String id){
        return updateDriver -> new Driver(
                DriverId.of(id),
                new Position(updateDriver.getPosition()),
                PlayerId.of(updateDriver.getPlayerId()),
                RailId.of(updateDriver.getRailId())
        );
    }

    public Function<Driver,DriverDTO> mapperToDTO(){
        return driver -> new DriverDTO(
                driver.getDriverId().getValue(),
                driver.getPosition().getValue(),
                driver.getPlayerId().getValue(),
                driver.getRailId().getValue()
        );
    }
}
