package co.com.demo.carsgame.mapper;

import co.com.demo.carsgame.domain.game.Track;
import co.com.demo.carsgame.domain.game.values.TrackDistance;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.domain.game.values.id.PodiumId;
import co.com.demo.carsgame.domain.game.values.id.TrackId;
import co.com.demo.carsgame.dto.TrackDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper {

    public Function<TrackDTO, Track> mapperToTrack(String id){
        return  updateTrack -> new Track(
                TrackId.of(id),
                new TrackDistance(updateTrack.getTrackDistance()),
                GameId.of(updateTrack.getGameId()),
                PodiumId.of(updateTrack.getPodiumId())
        );
    }

    public Function<Track,TrackDTO> mapperToDTO(){
        return track -> new TrackDTO(
                track.getTrackId().getValue(),
                track.getTrackDistance().getValue(),
                track.getGameId().getValue(),
                track.getPodiumId().getValue()
        );
    }
}