package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Podium;
import co.com.demo.carsgame.dto.PodiumDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodiumRepository extends ReactiveMongoRepository<PodiumDTO, String> {
}
