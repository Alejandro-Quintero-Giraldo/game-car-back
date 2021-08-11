package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.dto.CarDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDTORepository extends ReactiveMongoRepository<CarDTO, String> {
}
