package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.dto.TrackDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackDTORepository extends ReactiveMongoRepository<TrackDTO, String> {
}
