package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.PodiumDTO;
import co.com.demo.carsgame.mapper.PodiumMapper;
import co.com.demo.carsgame.repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdPodiumUseCase {

    private final PodiumRepository podiumRepository;
    private final PodiumMapper podiumMapper;

    @Autowired
    public FindByIdPodiumUseCase(PodiumRepository podiumRepository, PodiumMapper podiumMapper){
        this.podiumRepository = podiumRepository ;
        this.podiumMapper = podiumMapper;
    }

    public Mono<PodiumDTO> getfindbyid(String id){
        return podiumRepository.findById(id)
                .flatMap(
                        podium -> Mono.just(podiumMapper.mapperToPodiumDTO().apply(podium))
                );
    }
}
