package co.com.demo.carsgame.useCase.queries;


import co.com.demo.carsgame.dto.GameDTO;
import co.com.demo.carsgame.mapper.GameMapper;
import co.com.demo.carsgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdGameUseCase {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Autowired
    public FindByIdGameUseCase(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }


    public Mono<GameDTO> findById(String id) {
        return gameRepository.findById(id)
                .flatMap(
                        game -> Mono.just(gameMapper.mapperToGameDTO().apply(game))
                );
    }
}
