package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class PodiumId {

    private final String value;

    public static PodiumId of(String value){
        return  new PodiumId(value);
    }
    public String getValue(){
        return this.value;
    }
}
