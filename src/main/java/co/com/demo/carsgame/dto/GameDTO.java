package co.com.demo.carsgame.dto;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.domain.game.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "Game")
public class GameDTO {

    @Id
    private String gameId;
    private List<Player> players;
    private Boolean isFirstCareer;
    private List<Track>  tracks;
}