package co.com.demo.carsgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Driver")
public class DriverDTO {
    @Id
    private  String driverId;
    private Integer position;
    private  String playerId;
    private  String railId;
    private  String carId;

}