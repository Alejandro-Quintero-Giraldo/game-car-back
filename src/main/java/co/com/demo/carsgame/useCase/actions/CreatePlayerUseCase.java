package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.mapper.PlayerMapper;
import co.com.demo.carsgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreatePlayerUseCase{

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public CreatePlayerUseCase(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public Mono<PlayerDTO> apply(PlayerDTO playerDTO) {
        return playerRepository
                .save(playerMapper.mapperToPlayer(playerDTO.getPlayerId())
                        .apply(playerDTO))
                .map(playerMapper.mapperToPlayerDTO());
    }
}
