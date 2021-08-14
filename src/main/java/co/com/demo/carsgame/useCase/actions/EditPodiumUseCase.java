package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.PodiumDTO;
import co.com.demo.carsgame.repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EditPodiumUseCase {

    private final PodiumRepository podiumRepository;

    @Autowired
    public EditPodiumUseCase(PodiumRepository podiumRepository) {
        this.podiumRepository = podiumRepository;

    }

    public Mono<PodiumDTO> apply(PodiumDTO podiumDTO) {
        return podiumRepository.save(podiumDTO)
                .thenReturn(podiumDTO);
    }
}
