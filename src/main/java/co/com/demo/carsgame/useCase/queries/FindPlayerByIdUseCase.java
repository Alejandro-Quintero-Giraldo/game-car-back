package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.mapper.PlayerMapper;
import co.com.demo.carsgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class FindPlayerByIdUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public FindPlayerByIdUseCase(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public Mono<PlayerDTO> findById(String id){
        return playerRepository.findById(id);
    }
}
