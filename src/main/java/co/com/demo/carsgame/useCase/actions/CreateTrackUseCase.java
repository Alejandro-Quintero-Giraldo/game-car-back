package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.TrackDTO;
import co.com.demo.carsgame.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateTrackUseCase {

    private final TrackRepository  trackRepository;

    public CreateTrackUseCase(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Mono<TrackDTO> apply(TrackDTO trackDTO){
        return trackRepository
                .save(trackDTO)
                .thenReturn(trackDTO);
    }
}
