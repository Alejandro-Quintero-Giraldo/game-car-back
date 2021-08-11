package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.dto.PlayerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDTORepository extends ReactiveMongoRepository<PlayerDTO, String> {
}
