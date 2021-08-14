package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.dto.PlayerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<PlayerDTO, String> {
    Flux<PlayerDTO> findByGameId(String gameId);
}