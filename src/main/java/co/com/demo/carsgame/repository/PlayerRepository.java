package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.domain.game.values.id.GameId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
    Flux<Player> findByGameId(GameId gameId);
}
