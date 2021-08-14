package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Rail;
import co.com.demo.carsgame.dto.RailDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RailMapper {

    public Function<RailDTO, Rail> mapperToRail(String id){
        return updateRail -> {
            Rail rail = new Rail();
            rail.setRailId(id);
            rail.setCarId(updateRail.getCarId());
            rail.setGameId(updateRail.getGameId());
            rail.setTrackId(updateRail.getTrackId());
            rail.setDriverId(updateRail.getDriverId());
            return  rail;
        };
    }

    public Function<Rail,RailDTO> mapperToRailDTO(){
        return rail -> new RailDTO(
                rail.getRailId(),
                rail.getCarId(),
                rail.getGameId(),
                rail.getTrackId(),
                rail.getDriverId()
        );
    }
}
