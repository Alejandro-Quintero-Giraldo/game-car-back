package co.com.demo.carsgame.domain.game;

import co.com.demo.carsgame.domain.game.values.TrackDistance;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PodiumId;
import co.com.demo.carsgame.domain.game.values.id.TrackId;
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
@Document(collection = "Track")
public class Track {

    @Id
    private String trackId;
    private Integer trackDistance;
    private String gameId;
    private String podiumId;

}
