package co.com.demo.carsgame.domain.game.values.id;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class PlayerId {

    private final String value;

    public static PlayerId of(String value){
        return  new PlayerId(value);
    }
    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerId playerId = (PlayerId) o;
        return Objects.equals(value, playerId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String toString() {
        return this.value;
    }

    public Object Identity() {
        return this.value.toString();
    }
}
