package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Position {
    private final Integer value;

    public Position updatePosition(Integer value){
        return new Position(value);
    }
}
