package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Game;
import co.com.demo.carsgame.dto.GameDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends ReactiveMongoRepository<GameDTO, String> {
}
