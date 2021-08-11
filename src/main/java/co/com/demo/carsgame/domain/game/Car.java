package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.IsArrivedGoal;
import co.com.demo.carsgame.domain.game.values.id.CarId;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PlayerId;
import co.com.demo.carsgame.domain.game.values.id.RailId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Car")
public class Car {

    @Id
    private CarId id;
    private IsArrivedGoal isArrivedGoal;
    private PlayerId playerId;
    private GameId gameId;
    private RailId railId;

}
