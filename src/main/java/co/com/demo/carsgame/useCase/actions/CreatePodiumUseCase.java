package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.PodiumDTO;
import co.com.demo.carsgame.mapper.PodiumMapper;
import co.com.demo.carsgame.repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreatePodiumUseCase {

    private final PodiumRepository podiumRepository;
    private final PodiumMapper podiumMapper;

    @Autowired
    public CreatePodiumUseCase(PodiumRepository podiumRepository, PodiumMapper podiumMapper){
        this.podiumRepository = podiumRepository;
        this.podiumMapper = podiumMapper;
    }
    public Mono<PodiumDTO> apply(PodiumDTO podiumDTO){
        return podiumRepository.save(podiumMapper.mapperToPodium(podiumDTO.getPodiumId())
                .apply(podiumDTO))
                .map(podiumMapper.mapperToPodiumDTO());
    }
}
