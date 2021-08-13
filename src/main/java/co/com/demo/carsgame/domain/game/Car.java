package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.Advance;
import co.com.demo.carsgame.domain.game.values.CurrentPosition;
import co.com.demo.carsgame.domain.game.values.IsArrivedGoal;
import co.com.demo.carsgame.domain.game.values.id.*;
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
    private CurrentPosition currentPosition;
    private Advance advance;
    private DriverId driverId;
    private GameId gameId;
    private RailId railId;

}
