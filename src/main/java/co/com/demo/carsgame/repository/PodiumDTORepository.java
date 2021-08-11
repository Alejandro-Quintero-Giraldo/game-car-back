package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.dto.PodiumDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodiumDTORepository extends ReactiveMongoRepository<PodiumDTO, String> {
}
