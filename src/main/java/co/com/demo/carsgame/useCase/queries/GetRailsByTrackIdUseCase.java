package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.mapper.RailMapper;
import co.com.demo.carsgame.repository.RailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetRailsByTrackIdUseCase {

    private final RailRepository railRepository;
    private final RailMapper railMapper;

    @Autowired
    public GetRailsByTrackIdUseCase(RailRepository repositoryRail, RailMapper railMapper) {
        this.railRepository = repositoryRail;
        this.railMapper = railMapper;
    }

    public Flux<RailDTO> getRailByTrackId(String id){
        return railRepository.findByTrackId(id)
                .flatMap(
                        rail -> Flux.just(railMapper.mapperToRailDTO().apply(rail))
                );
    }
}
