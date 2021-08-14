package co.com.demo.carsgame.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Driver")
public class Driver {

    @Id
    private final String driverId;
    private final Integer position;
    private final String playerId;
    private final String railId;
    private final String carId;

}
