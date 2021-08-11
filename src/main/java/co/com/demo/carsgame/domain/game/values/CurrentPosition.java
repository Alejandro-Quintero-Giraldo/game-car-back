package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CurrentPosition {

    private Integer value;

    public void updateCurrentPosition(Integer value){
        this.value = this.getValue() + value;
    }

    public CurrentPosition initializeCurrentPosition(){
        return new CurrentPosition(0);
    }
}
