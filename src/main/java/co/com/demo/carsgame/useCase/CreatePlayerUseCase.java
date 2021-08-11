package co.com.demo.carsgame.useCase;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.mapper.PlayerMapper;
import co.com.demo.carsgame.repository.PlayerDTORepository;
import co.com.demo.carsgame.useCase.interfaceFunctions.ICreatePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreatePlayerUseCase implements ICreatePlayer {

    private final PlayerDTORepository playerDTORepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public CreatePlayerUseCase(PlayerDTORepository playerDTORepository, PlayerMapper playerMapper) {
        this.playerDTORepository = playerDTORepository;
        this.playerMapper = playerMapper;
    }

    @Override
    public Mono<String> apply(PlayerDTO playerDTO) {
        return playerDTORepository
                .save(playerDTO)
                .map(PlayerDTO::getPlayerId);
    }
}
