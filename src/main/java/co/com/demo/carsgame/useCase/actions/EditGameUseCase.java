package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.GameDTO;
import co.com.demo.carsgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EditGameUseCase {

    private final GameRepository gameRepository;

    @Autowired
    public EditGameUseCase(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Mono<GameDTO> modifyGame(GameDTO gameDTO){
        return
                gameRepository.save(gameDTO)
                        .thenReturn(gameDTO);
    }
}
