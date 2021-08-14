package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Car;
import co.com.demo.carsgame.dto.CarDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CarRepository extends ReactiveMongoRepository<CarDTO, String> {
    Flux<CarDTO> findByDriverId(String driverId);
}
