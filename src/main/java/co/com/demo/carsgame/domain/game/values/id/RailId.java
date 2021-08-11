package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class RailId {

    private final String value;

    public static RailId of(String value){
        return  new RailId(value);
    }
    public String getValue(){
        return this.value;
    }
}
