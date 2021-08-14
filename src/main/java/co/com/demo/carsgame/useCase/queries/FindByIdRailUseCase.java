package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.mapper.RailMapper;
import co.com.demo.carsgame.repository.RailRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdRailUseCase {

    private final RailRepository railRepository;
    private final RailMapper railMapper;

    public FindByIdRailUseCase(RailRepository repositoryRail, RailMapper railMapper) {
        this.railRepository = repositoryRail;

        this.railMapper = railMapper;
    }

    public Mono<RailDTO> getfindbyid(String id){
        return railRepository.findById(id)
                .flatMap(
                        rail -> Mono.just(railMapper.mapperToRailDTO().apply(rail))
                );
    }
}
