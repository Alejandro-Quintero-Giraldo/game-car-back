package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Game;
import co.com.demo.carsgame.dto.GameDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GameMapper {
    public Function<GameDTO, Game> mapperToGame(String id){
        return updateGame -> {
            Game game = new Game();
            game.setGameId(id);
            game.setTrackId(updateGame.getTrackId());
            return  game;
        };
    }

    public Function<Game,GameDTO> mapperToGameDTO(){
        return game -> new GameDTO(
                game.getGameId(),
                game.getTrackId()
        );
    }
}
