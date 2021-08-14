package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Driver;
import co.com.demo.carsgame.dto.DriverDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DriverMapper {


    public Function<DriverDTO, Driver> mapperToDriver(String id){
        return updateDriver -> {
            Driver driver = new Driver();
            driver.setDriverId(id);
            driver.setPosition(updateDriver.getPosition());
            driver.setPlayerId(updateDriver.getPlayerId());
            driver.setRailId(updateDriver.getRailId());
            driver.setCarId(updateDriver.getCarId());
            return driver;
        };
    }

    public Function<Driver,DriverDTO> mapperToDriverDTO(){
        return driver -> new DriverDTO(
                driver.getDriverId(),
                driver.getPosition(),
                driver.getPlayerId(),
                driver.getRailId(),
                driver.getCarId()
        );
    }
}
