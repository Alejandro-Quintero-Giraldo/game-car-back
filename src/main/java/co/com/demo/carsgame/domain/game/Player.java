package co.com.demo.carsgame.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Player")
public class Player {

    @Id
    private String playerId;
    private String name;
    private Integer firstPlace;
    private Integer secondPlace;
    private Integer thirdPlace;
    private String gameId;
    private String driverId;
}
