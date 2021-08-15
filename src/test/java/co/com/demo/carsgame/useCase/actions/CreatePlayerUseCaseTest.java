package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.dto.PlayerDTO;
import co.com.demo.carsgame.repository.PlayerRepository;
import co.com.demo.carsgame.useCase.actions.CreatePlayerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static reactor.core.publisher.Mono.when;


@SpringBootTest
class CreatePlayerUseCaseTest {

    @SpyBean
    CreatePlayerUseCase createPlayerUseCase;

    @MockBean
    PlayerRepository playerRepository;

    @Test
    void createPlayer(){
        PlayerDTO playerInput =
                new PlayerDTO("1", "Kudo", 0,0,0,"1", "1");

        Player player = new Player("1", "Kudo", 0, 0, 0,"1", "1");


        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(Mono.just(player));

        Mono<PlayerDTO> playerDTOMono = createPlayerUseCase.apply(playerInput);

        Assertions.assertEquals(playerInput.getPlayerId(),playerDTOMono.block() );


    }
}