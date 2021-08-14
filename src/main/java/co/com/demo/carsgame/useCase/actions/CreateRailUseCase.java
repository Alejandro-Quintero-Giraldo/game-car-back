package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.mapper.RailMapper;
import co.com.demo.carsgame.repository.RailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateRailUseCase {

    private final RailRepository railRepository;
    private final RailMapper railMapper;

    @Autowired
    public CreateRailUseCase(RailRepository repositoryRail, RailMapper railMapper) {
        this.railRepository = repositoryRail;
        this.railMapper = railMapper;
    }

    public Mono<RailDTO> createRail(RailDTO railDTO){
        return railRepository.save(railMapper.mapperToRail(railDTO.getRailId())
                .apply(railDTO))
                .map(railMapper.mapperToRailDTO());
    }
}
