package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.Advance;
import co.com.demo.carsgame.domain.game.values.CurrentPosition;
import co.com.demo.carsgame.domain.game.values.id.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Rail")
public class Rail {

    @Id
    private RailId railId;
    private CurrentPosition currentPosition;
    private Advance advance;
    private CarId carId;
    private GameId gameId;
    private TrackId trackId;
    private PlayerId playerId;
}