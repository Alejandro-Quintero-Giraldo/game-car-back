package co.com.demo.carsgame.useCase.queries;


import co.com.demo.carsgame.dto.GameDTO;
import co.com.demo.carsgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByGameIdUseCase {

    private final GameRepository gameRepository;

    @Autowired
    public FindByGameIdUseCase(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public Mono<GameDTO> findById(String id) {
        return gameRepository.findById(id);
    }
}
