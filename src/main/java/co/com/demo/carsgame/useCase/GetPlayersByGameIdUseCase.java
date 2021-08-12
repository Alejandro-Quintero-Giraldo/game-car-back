package co.com.demo.carsgame.useCase;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.mapper.PlayerMapper;
import co.com.demo.carsgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetPlayersByGameIdUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public GetPlayersByGameIdUseCase(PlayerRepository playerDTORepository, PlayerMapper playerMapper) {
        this.playerRepository = playerDTORepository;
        this.playerMapper = playerMapper;
    }

    public Flux<PlayerDTO> getPlayersByGameId(String id){
        return playerRepository.findByGameId(GameId.of(id))
                .flatMap(
                        player -> Flux.just(playerMapper.mapperToDTO().apply(player))
                );

    }
}
