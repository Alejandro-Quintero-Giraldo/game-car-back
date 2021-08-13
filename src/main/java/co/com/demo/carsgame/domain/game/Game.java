package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.IsFirstCareer;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.TrackId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Game")
public class Game {
    @Id
    private GameId gameId;
    private TrackId trackId;


}
