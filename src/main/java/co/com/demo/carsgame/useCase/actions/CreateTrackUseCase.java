package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.domain.game.Track;
import co.com.demo.carsgame.dto.TrackDTO;
import co.com.demo.carsgame.mapper.TrackMapper;
import co.com.demo.carsgame.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateTrackUseCase {

    private final TrackRepository  trackRepository;
    private final TrackMapper trackMapper;

    @Autowired
    public CreateTrackUseCase(TrackRepository trackRepository, TrackMapper trackMapper) {
        this.trackRepository = trackRepository;
        this.trackMapper = trackMapper;
    }

    public void apply(TrackDTO trackDTO){
         trackRepository.save(trackMapper.mapperToTrack(trackDTO.getTrackId())
                        .apply(trackDTO))
                .subscribe();
    }
}
