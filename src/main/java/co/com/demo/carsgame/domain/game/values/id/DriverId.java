package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DriverId {
    private final String value;

    public static DriverId of(String value){
        return  new DriverId(value);
    }

    public String getValue(){
        return this.value;
    }
}
