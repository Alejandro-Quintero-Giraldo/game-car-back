package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.WinnerPosition;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PodiumId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Podium")
public class Podium {

    @Id
    private PodiumId podiumId;
    private WinnerPosition firstPlace;
    private WinnerPosition secondPlace;
    private WinnerPosition thirdPlace;
    private GameId gameId;
}
