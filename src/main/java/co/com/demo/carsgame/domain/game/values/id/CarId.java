package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarId {
    private final String value;

    public static CarId of(String value){
        return  new CarId(value);
    }

    public String getValue(){
        return this.value;
    }
}