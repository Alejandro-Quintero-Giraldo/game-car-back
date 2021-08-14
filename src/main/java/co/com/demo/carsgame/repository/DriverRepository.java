package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Driver;
import co.com.demo.carsgame.dto.DriverDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends ReactiveMongoRepository<DriverDTO, String> {
}
