package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.GameDTO;
import co.com.demo.carsgame.mapper.GameMapper;
import co.com.demo.carsgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateGameUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Autowired
    public CreateGameUseCase(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public void createGame(GameDTO gameDTO){
        gameRepository.save(gameMapper.mapperToGame(gameDTO.getGameId())
                .apply(gameDTO)).subscribe();
    }
}
