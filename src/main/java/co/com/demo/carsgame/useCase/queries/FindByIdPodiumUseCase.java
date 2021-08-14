package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.PodiumDTO;
import co.com.demo.carsgame.repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdPodiumUseCase {

    private final PodiumRepository podiumRepository;

    @Autowired
    public FindByIdPodiumUseCase(PodiumRepository podiumRepository){
        this.podiumRepository = podiumRepository ;  }

    public Mono<PodiumDTO> getfindbyid(String id){
        return podiumRepository.findById(id);
    }
}
