package co.com.demo.carsgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "Driver")
public class DriverDTO {
    @Id
    private final String driverId;
    private final Integer position;
    private final String playerId;
    private final String railId;
    private final String carId;
}
