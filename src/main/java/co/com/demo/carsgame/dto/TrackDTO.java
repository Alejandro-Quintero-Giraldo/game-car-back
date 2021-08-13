package co.com.demo.carsgame.dto;

import co.com.demo.carsgame.domain.game.Rail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Track")
public class TrackDTO {

    @Id
    private String trackId;
    private Integer trackDistance;
    private List<Rail> rails;
    private String gameId;
    private String podiumId;
}
