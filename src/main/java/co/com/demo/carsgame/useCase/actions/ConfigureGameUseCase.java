package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.domain.game.Track;
import co.com.demo.carsgame.dto.GameDTO;
import co.com.demo.carsgame.dto.TrackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ConfigureGameUseCase {
/*
    private final CreateGameUseCase createGameUseCase;
    private final CreateTrackUseCase createTrackUseCase;

    @Autowired
    public ConfigureGameUseCase(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    public Mono<String> configureGame(GameDTO gameDTO, TrackDTO trackDTO){
        return createGameUseCase.createGame(gameDTO)
                .flatMap(
                createTrackUseCase.createTrack(trackDTO);

        )

    }*/
}
