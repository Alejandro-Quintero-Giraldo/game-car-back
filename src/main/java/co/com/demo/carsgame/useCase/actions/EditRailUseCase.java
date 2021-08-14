package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.RailDTO;
import co.com.demo.carsgame.repository.RailRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EditRailUseCase {

    private final RailRepository railRepository;



    public EditRailUseCase(RailRepository repositoryRail ) {
        this.railRepository = repositoryRail;

    }
    public Mono<RailDTO> apply(RailDTO railDTO){
        return railRepository
                .save(railDTO)
                .thenReturn(railDTO);
    }
}
