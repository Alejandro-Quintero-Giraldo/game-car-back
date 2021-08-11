package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuantityWinnerPosition {

    private Integer value;

    public void incrementValue(){
        this.value = this.getValue()+1;
    }
}
