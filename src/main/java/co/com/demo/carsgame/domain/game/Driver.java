package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.Position;
import co.com.demo.carsgame.domain.game.values.id.CarId;
import co.com.demo.carsgame.domain.game.values.id.DriverId;
import co.com.demo.carsgame.domain.game.values.id.PlayerId;
import co.com.demo.carsgame.domain.game.values.id.RailId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Document(collection = "Driver")
public class Driver {

    @Id
    private final DriverId driverId;
    private final Position position;
    private final PlayerId playerId;
    private final RailId railId;
    private final CarId carId;

}
