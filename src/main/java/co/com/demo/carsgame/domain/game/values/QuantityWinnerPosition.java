package co.com.demo.carsgame.domain.game.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuantityWinnerPosition {

    private final Integer value;

    public QuantityWinnerPosition incrementValue(Integer value) {
        return new QuantityWinnerPosition(value);
    }
}
