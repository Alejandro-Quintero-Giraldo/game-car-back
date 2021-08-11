package co.com.demo.carsgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Rail")
public class RailDTO {

    @Id
    private String railId;
    private Integer currentPosition;
    private Integer advance;
    private String carId;
    private String gameId;
    private String trackId;
    private String playerId;
}