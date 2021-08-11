package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.dto.PlayerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
}
