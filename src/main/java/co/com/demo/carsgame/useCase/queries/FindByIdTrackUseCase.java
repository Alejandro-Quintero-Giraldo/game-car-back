package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.TrackDTO;
import co.com.demo.carsgame.mapper.TrackMapper;
import co.com.demo.carsgame.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdTrackUseCase {

    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;

    @Autowired
    public FindByIdTrackUseCase(TrackRepository trackRepository, TrackMapper trackMapper) {
        this.trackRepository = trackRepository;
        this.trackMapper = trackMapper;
    }

    public Mono<TrackDTO> getfindbyid(String id){
        return trackRepository.findById(id)
                .flatMap(
                        track -> Mono.just(trackMapper.mapperToTrackDTO().apply(track))
                );
    }
}
