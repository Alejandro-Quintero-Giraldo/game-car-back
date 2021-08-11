package co.com.demo.carsgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Car")
public class CarDTO {

    @Id
    private String id;
    private Boolean isArrivedGoal;
    private String playerId;
    private String gameId;
    private String railId;
}
