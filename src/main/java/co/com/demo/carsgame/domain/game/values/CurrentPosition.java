package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentPosition {

    private final Integer value;

    public CurrentPosition updateCurrentPosition(Integer value){
        return new CurrentPosition(value);
    }

    public CurrentPosition initializeCurrentPosition(){
        return new CurrentPosition(0);
    }
}
