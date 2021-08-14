package co.com.demo.carsgame.useCase;

import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.useCase.actions.CreatePlayerUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;



@SpringBootTest
class CreatePlayerUseCaseTest {
    @Autowired
    CreatePlayerUseCase createPlayerUseCase;

    @Test
    void createPlayer(){
        PlayerDTO playerInput =
                new PlayerDTO("1", "Sebas", 0,0,0,"1", "1");

        Mono<PlayerDTO> playerDTO = createPlayerUseCase.apply(playerInput);

        StepVerifier.create(playerDTO)
                .expectNextMatches(playerDTO1 -> playerDTO1.getPlayerId()
                        .equals(playerInput.getPlayerId()))
                .verifyComplete();
    }
}