package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.domain.game.Track;
import co.com.demo.carsgame.dto.*;
import co.com.demo.carsgame.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@Validated
public class ConfigureGameUseCase {

    private final CreateGameUseCase createGameUseCase;

    private final CreateTrackUseCase createTrackUseCase;
    private final CreatePlayerUseCase createPlayerUseCase;
    private final EditGameUseCase editGameUseCase;
    private final CreateDriverUseCase createDriverUseCase;
    private final CreateCarUseCase createCarUseCase;
    private final CreateRailUseCase createRailUseCase;
    private final EditDriverUseCase editDriverUseCase;
    private final EditCarUseCase editCarUseCase;
    private final EditPlayerUseCase editPlayerUseCase;

    @Autowired
    public ConfigureGameUseCase( CreateGameUseCase createGameUseCase, CreateTrackUseCase createTrackUseCase, CreatePlayerUseCase createPlayerUseCase, EditGameUseCase editGameUseCase, CreateDriverUseCase createDriverUseCase, CreateCarUseCase createCarUseCase, CreateRailUseCase createRailUseCase, EditDriverUseCase editDriverUseCase, EditCarUseCase editCarUseCase, EditPlayerUseCase editPlayerUseCase) {
        this.createGameUseCase = createGameUseCase;
        this.createTrackUseCase = createTrackUseCase;
        this.createPlayerUseCase = createPlayerUseCase;
        this.editGameUseCase = editGameUseCase;
        this.createDriverUseCase = createDriverUseCase;
        this.createCarUseCase = createCarUseCase;
        this.createRailUseCase = createRailUseCase;
        this.editDriverUseCase = editDriverUseCase;
        this.editCarUseCase = editCarUseCase;
        this.editPlayerUseCase = editPlayerUseCase;
    }

    public Mono<String> configureGame(List<String> playersNames, String trackDistance){

        GameDTO gameDTO = new GameDTO(UUID.randomUUID().toString(),null);
        TrackDTO trackDTO = new TrackDTO(UUID.randomUUID().toString(),Integer.parseInt(trackDistance),gameDTO.getGameId(),null);
        GameDTO gameEdited = new GameDTO(gameDTO.getGameId(), trackDTO.getTrackId());

       return playersNames.stream().count()<3 ? Mono.just("Faltan peludos") : createPlayers(playersNames, gameDTO.getGameId(), trackDTO.getTrackId())
               .map(
                      string  -> {
                          createGameUseCase.createGame(gameDTO);
                          createTrackUseCase.apply(trackDTO);
                          System.out.println("Id track"+ gameEdited.getTrackId());
                          editGameUseCase.editGame(gameEdited);
                          return  string;
                      }
               );
    }

    public void createEntities(String gameId, String trackId, PlayerDTO playerDTO){

        DriverDTO driverDTO =
                new DriverDTO(UUID.randomUUID().toString(),null, playerDTO.getPlayerId(), null, null );
        CarDTO carDTO =
                new CarDTO(UUID.randomUUID().toString(),Boolean.FALSE, 0, 0,driverDTO.getDriverId(),gameId,null);
        RailDTO railDTO =
                new RailDTO(UUID.randomUUID().toString(),carDTO.getId(),gameId,trackId,driverDTO.getDriverId());
        DriverDTO driverEdited =
                new DriverDTO(driverDTO.getDriverId(), null, playerDTO.getPlayerId(), railDTO.getRailId(),carDTO.getId());
        CarDTO carEdited =
                new CarDTO(carDTO.getId(),carDTO.getIsArrivedGoal(),carDTO.getCurrentPosition(),carDTO.getCurrentPosition(),driverDTO.getDriverId(),gameId,railDTO.getRailId());
        PlayerDTO playerEdited =
                new PlayerDTO(playerDTO.getPlayerId(), playerDTO.getName(), 0, 0, 0, gameId, driverDTO.getDriverId());

         createDriverUseCase.apply(driverDTO);
         createCarUseCase.createCar(carDTO);
         createRailUseCase.createRail(railDTO);
         editDriverUseCase.modifyDriver(driverEdited);
         editCarUseCase.modifyCar(carEdited);
         editPlayerUseCase.modifyPlayer(playerEdited);
    }

    public Mono<String> createPlayers(List<String> listNames, String gameId, String trackId){

        listNames.forEach(
                name -> {
                    PlayerDTO playerDTO = new PlayerDTO(UUID.randomUUID().toString(), name, 0, 0, 0, gameId,null );
                    createPlayerUseCase.apply(playerDTO);
                    createEntities(gameId, trackId, playerDTO);
                }
        );

        return  Mono.just("Game configured");
    }
}
