package co.com.demo.carsgame.useCase.interfaceFunctions;

import co.com.demo.carsgame.domain.game.Player;
import co.com.demo.carsgame.dto.PlayerDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreatePlayer {
    Mono<String> apply(PlayerDTO playerDTO);
}
