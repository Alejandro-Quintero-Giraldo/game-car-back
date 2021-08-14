package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.PlayerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FindPlayerByIdUseCaseTest {

    @Autowired
    FindPlayerByIdUseCase findPlayerByIdUseCase;

    @Test
    void findByIdPlayer(){
        PlayerDTO playerInput =
                new PlayerDTO("9", "Sebas", 0, 0, 0,"5","8");

        Mono<PlayerDTO> playerDTO = findPlayerByIdUseCase.findById("9");

        StepVerifier.create(playerDTO).assertNext(playerDTO1 -> {
                    assertNotNull(playerDTO1);
                    assertThat(playerDTO1.getPlayerId(), is(equalTo("9")));
                })
                .expectComplete()
                .verify();
    }


}