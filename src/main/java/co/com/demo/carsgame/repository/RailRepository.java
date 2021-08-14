package co.com.demo.carsgame.repository;

import co.com.demo.carsgame.domain.game.Rail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface RailRepository extends ReactiveMongoRepository<Rail, String> {
    Flux<Rail> findByTrackId(String id);
}
