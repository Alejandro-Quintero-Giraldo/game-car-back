package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PlayerMapper {

    public Function<PlayerDTO, Player> mapperToPlayer(String id){
        return updatePlayer -> {
            Player player = new Player();
            player.setPlayerId(id);
            player.setName(updatePlayer.getName());
            player.setFirstPlace(updatePlayer.getFirstPlace());
            player.setSecondPlace(updatePlayer.getSecondPlace());
            player.setThirdPlace(updatePlayer.getThirdPlace());
            player.setGameId(updatePlayer.getGameId());
            player.setDriverId(updatePlayer.getDriverId());
            return player;
        };
    }

    public Function<Player,PlayerDTO> mapperToPlayerDTO(){
        return player -> new PlayerDTO(
                player.getPlayerId(),
                player.getName(),
                player.getFirstPlace(),
                player.getSecondPlace(),
                player.getThirdPlace(),
                player.getGameId(),
                player.getDriverId()
        );
    }
}
