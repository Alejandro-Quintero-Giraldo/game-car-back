package co.com.demo.carsgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Car")
public class CarDTO {

    @Id
    private String id;
    private Boolean isArrivedGoal;
    private Integer currentPosition;
    private Integer advance;
    private String driverId;
    private String gameId;
    private String railId;

}