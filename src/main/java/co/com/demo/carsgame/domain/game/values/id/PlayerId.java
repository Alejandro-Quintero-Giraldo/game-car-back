package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class PlayerId {

    private final String value;

    public static PlayerId of(String value){
        return  new PlayerId(value);
    }
    public String getValue(){
        return this.value;
    }
}
