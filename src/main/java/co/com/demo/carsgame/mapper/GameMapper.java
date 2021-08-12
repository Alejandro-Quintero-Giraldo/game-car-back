package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Game;
import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.domain.game.values.IsFirstCareer;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.dto.GameDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component
public class GameMapper {
    public Function<GameDTO, Game> mapperToGame(String id){
        return updateGame -> new Game(
          GameId.of(id),
          new ArrayList<>(updateGame.getPlayers()),
          new IsFirstCareer(updateGame.getIsFirstCareer())
        );
    }

    public Function<Game,GameDTO> mapperToDTO(){
        return game -> new GameDTO(
                game.getGameId().getValue(),
                game.getPlayers(),
                game.getIsFirstCareer().getValue()
        );
    }

}
