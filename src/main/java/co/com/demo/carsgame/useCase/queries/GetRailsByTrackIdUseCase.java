package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.repository.RailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetRailsByTrackIdUseCase {

    private final RailRepository railRepository;


    @Autowired
    public GetRailsByTrackIdUseCase(RailRepository repositoryRail) {
        this.railRepository = repositoryRail;
    }

    public Flux<RailDTO> getRailByTrackId(String id){
        return railRepository.findByTrackId(id);
    }
}
