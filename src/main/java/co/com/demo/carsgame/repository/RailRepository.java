package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Rail;
import co.com.demo.carsgame.dto.RailDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface RailRepository extends ReactiveMongoRepository<RailDTO, String> {
    Flux<RailDTO> findByTrackId(String id);
}
