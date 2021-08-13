package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.domain.game.values.Name;
import co.com.demo.carsgame.domain.game.values.QuantityWinnerPosition;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PlayerId;
import co.com.demo.carsgame.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PlayerMapper {

    public Function<PlayerDTO, Player> mapperToPlayer(String id){
        return updatePlayer -> new Player(
                PlayerId.of(id),
                new Name(updatePlayer.getName()),
                new QuantityWinnerPosition(updatePlayer.getFirstPlace()),
                new QuantityWinnerPosition(updatePlayer.getSecondPlace()),
                new QuantityWinnerPosition(updatePlayer.getThirdPlace()),
                GameId.of(updatePlayer.getGameId())
        );
    }

    public Function<Player,PlayerDTO> mapperToDTO(){
        return player -> new PlayerDTO(
                player.getPlayerId().getValue(),
                player.getName().getValue(),
                player.getFirstPlace().getValue(),
                player.getSecondPlace().getValue(),
                player.getThirdPlace().getValue(),
                player.getGameId().getValue()
        );
    }
}
