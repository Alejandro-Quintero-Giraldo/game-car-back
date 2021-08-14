package co.com.demo.carsgame.domain.game.values;

import co.com.demo.carsgame.domain.game.values.id.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
//@Getter
public class Name {

    private final String value;

    public String getValue(){
        return this.value;
    }
}
