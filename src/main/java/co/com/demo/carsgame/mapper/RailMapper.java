package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Rail;
import co.com.demo.carsgame.domain.game.values.Advance;
import co.com.demo.carsgame.domain.game.values.CurrentPosition;
import co.com.demo.carsgame.domain.game.values.id.*;
import co.com.demo.carsgame.dto.RailDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RailMapper {

    public Function<RailDTO, Rail> mapperToRail(String id){
        return updateRail -> new Rail(
                RailId.of(id),
                new CurrentPosition(updateRail.getCurrentPosition()),
                new Advance(updateRail.getAdvance()),
                CarId.of(updateRail.getCarId()),
                GameId.of(updateRail.getGameId()),
                TrackId.of(updateRail.getTrackId()),
                PlayerId.of(updateRail.getPlayerId())
        );
    }

    public Function<Rail,RailDTO> mapperToDTO(){
        return rail -> new RailDTO(
                rail.getRailId().getValue(),
                rail.getCurrentPosition().getValue(),
                rail.getAdvance().getValue(),
                rail.getCarId().getValue(),
                rail.getGameId().getValue(),
                rail.getTrackId().getValue(),
                rail.getPlayerId().getValue()
        );
    }
}
