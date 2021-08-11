package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Advance {

    private Integer value;

    public void incrementAdvance(Integer value){
        this.value = this.getValue()+value;
    }
}
