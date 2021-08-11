package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class TrackId {

    private final String value;

    public static TrackId of(String value){
        return  new TrackId(value);
    }

    public String getValue(){
        return this.value;
    }
}
