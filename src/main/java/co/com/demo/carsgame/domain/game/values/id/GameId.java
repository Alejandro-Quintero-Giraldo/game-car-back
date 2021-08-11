package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class GameId {
    private final String value;

    public static GameId of(String value){
        return  new GameId(value);
    }
    public String getValue(){
        return this.value;
    }
}
