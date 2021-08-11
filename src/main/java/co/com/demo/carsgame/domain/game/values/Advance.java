package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Advance {

    private final Integer value;

    public Advance incrementAdvance(Integer value){
       return new Advance(value);
    }
}
