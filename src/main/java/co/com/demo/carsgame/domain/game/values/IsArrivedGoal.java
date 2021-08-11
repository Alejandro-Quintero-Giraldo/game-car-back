package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IsArrivedGoal {

    private Boolean value;

    public static IsArrivedGoal trueValue(){
        return new IsArrivedGoal(Boolean.TRUE);
    }
}
