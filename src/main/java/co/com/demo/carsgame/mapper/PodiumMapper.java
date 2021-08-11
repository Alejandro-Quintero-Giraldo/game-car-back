package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Podium;
import co.com.demo.carsgame.domain.game.values.WinnerPosition;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PodiumId;
import co.com.demo.carsgame.dto.PodiumDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PodiumMapper {

    public Function<PodiumDTO, Podium> mapperToPodium(String id){
        return updatePodium -> new Podium(
          PodiumId.of(id),
          new WinnerPosition(updatePodium.getFirstPlace()),
          new WinnerPosition(updatePodium.getSecondPlace()),
          new WinnerPosition(updatePodium.getThirdPlace()),
          GameId.of(updatePodium.getGameId())
        );
    }

    public Function<Podium,PodiumDTO> mapperToDTO(){
    return podium -> new PodiumDTO(
            podium.getPodiumId().getValue(),
            podium.getFirstPlace().getValue(),
            podium.getSecondPlace().getValue(),
            podium.getThirdPlace().getValue(),
            podium.getGameId().getValue()
    );
    }
}
