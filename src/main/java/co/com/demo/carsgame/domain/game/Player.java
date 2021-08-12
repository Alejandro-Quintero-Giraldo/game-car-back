package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.Name;
import co.com.demo.carsgame.domain.game.values.QuantityWinnerPosition;
import co.com.demo.carsgame.domain.game.values.id.CarId;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Player")
public class Player {

    @Id
    private PlayerId playerId;
    private Name name;
    private QuantityWinnerPosition firstPlace;
    private QuantityWinnerPosition secondPlace;
    private QuantityWinnerPosition thirdPlace;
    private CarId carId;
    private GameId gameId;
}
