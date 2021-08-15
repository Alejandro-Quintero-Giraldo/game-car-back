package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.*;
import co.com.demo.carsgame.useCase.queries.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Validated
public class StartGameUseCase {

    private final FindByIdGameUseCase findByIdGameUseCase;
    private final FindByIdTrackUseCase findByIdTrackUseCase;
    private final FindByIdPlayerUseCase findByIdPlayerUseCase;
    private final FindByIdDriverUseCase findByIdDriverUseCase;
    private final EditTrackUseCase editTrackUseCase;
    private final GetPlayersByGameIdUseCase getPlayersByGameIdUseCase;
    private final GetCarByDriverIdUseCase getCarByDriverIdUseCase;
    private final CreatePodiumUseCase createPodiumUseCase;
    private final EditCarUseCase editCarUseCase;
    private final EditPodiumUseCase editPodiumUseCase;

    private final String[] result;

    @Autowired
    public StartGameUseCase(String[] result, FindByIdGameUseCase findByIdGameUseCase, FindByIdTrackUseCase findByIdTrackUseCase, FindByIdPlayerUseCase findByIdPlayerUseCase, FindByIdDriverUseCase findByIdDriverUseCase, EditTrackUseCase editTrackUseCase, GetPlayersByGameIdUseCase getPlayersByGameIdUseCase, GetCarByDriverIdUseCase getCarByDriverIdUseCase, CreatePodiumUseCase createPodiumUseCase, EditCarUseCase editCarUseCase, EditPodiumUseCase editPodiumUseCase) {
        this.result = result;
        this.findByIdGameUseCase = findByIdGameUseCase;
        this.findByIdTrackUseCase = findByIdTrackUseCase;
        this.findByIdPlayerUseCase = findByIdPlayerUseCase;
        this.findByIdDriverUseCase = findByIdDriverUseCase;
        this.editTrackUseCase = editTrackUseCase;
        this.getPlayersByGameIdUseCase = getPlayersByGameIdUseCase;
        this.getCarByDriverIdUseCase = getCarByDriverIdUseCase;
        this.createPodiumUseCase = createPodiumUseCase;
        this.editCarUseCase = editCarUseCase;
        this.editPodiumUseCase = editPodiumUseCase;
    }

    public Mono<String> StartGame(String gameId){


        Mono<GameDTO> gameMono = findByIdGameUseCase.findById(gameId);

        Flux<PlayerDTO> playersFlux = getPlayersByGameIdUseCase.getPlayersByGameId(gameId);

        gameMono.map(GameDTO::getTrackId).subscribe(
                idTrack -> {
                    Mono<TrackDTO> trackDTOMono = findByIdTrackUseCase.getfindbyid(idTrack);
                    System.out.println("Id Track"+ idTrack);
                    final Integer[] trackDistance = new Integer[1];

                    trackDTOMono.map(
                            trackDTO -> {
                                trackDistance[0] = trackDTO.getTrackDistance();
                                return trackDTO;
                            }
                    );
                    System.out.println("trackDistance: "+trackDistance[0]);

                    PodiumDTO podiumDTO = new PodiumDTO(UUID.randomUUID().toString(),null, null, null, gameId);
                    TrackDTO trackDTO = new TrackDTO(idTrack,trackDistance[0],gameId, podiumDTO.getPodiumId());
                    createPodiumUseCase.apply(podiumDTO);
                    editTrackUseCase.apply(trackDTO);
                    StartCareer(podiumDTO,trackDistance, playersFlux);
                }
        );



        return Mono.just(result[0]);
    };

    public void StartCareer(PodiumDTO podiumDTO, Integer[] trackDistance, Flux<PlayerDTO> playersFlux){
        while(podiumDTO.getThirdPlace() == null){
            playersFlux.map(
                    playerDTO -> {
                        //Mono<DriverDTO> driverDTO = findByIdDriverUseCase.findByIdDriver(playerDTO.getDriverId());

                        final String[] carId = new String[1];
                        final Integer[] currentPosition = new Integer[1];
                        final String[] railId = new String[1];
                        Integer dice = throwDices();
                        getCarByDriverIdUseCase.findCarsByDriverId(playerDTO.getDriverId()).map(
                                carDTO -> {
                                    carId[0] = carDTO.getId();
                                    currentPosition[0] = carDTO.getCurrentPosition();
                                    railId[0] = carDTO.getRailId();
                                    return  carDTO;
                                }
                        );

                        CarDTO carDTO = new CarDTO(carId[0],Boolean.FALSE,currentPosition[0]+dice,dice,playerDTO.getDriverId(), podiumDTO.getGameId(),railId[0]);
                        editCarUseCase.modifyCar(carDTO);

                        Mono<PodiumDTO>  ternary = currentPosition[0] >= trackDistance[0] ? verifyWinnerPosition(podiumDTO, playerDTO.getName()) : Mono.just(podiumDTO);
                        return playerDTO;
                    }
            );

        }
    }

    public Mono<PodiumDTO> verifyWinnerPosition(PodiumDTO podiumDTO, String name){
       return podiumDTO.getFirstPlace() == null
                ?  editPodiumUseCase.apply(new PodiumDTO(
                podiumDTO.getPodiumId(), name, null, null, podiumDTO.getGameId()
        ))
                : podiumDTO.getSecondPlace() == null
                ? editPodiumUseCase.apply(new PodiumDTO(
                podiumDTO.getPodiumId(), podiumDTO.getFirstPlace(), name, null, podiumDTO.getGameId()
        ))
                : podiumDTO.getThirdPlace() == null
                ? editPodiumUseCase.apply(new PodiumDTO(
                podiumDTO.getPodiumId(), podiumDTO.getFirstPlace(), podiumDTO.getSecondPlace(), name, podiumDTO.getGameId()
        ))
                : resultsGame(podiumDTO);
    }

    public Integer throwDices(){
        return (int) ((Math.random()*6+1)*100);
    }

    public Mono<PodiumDTO> resultsGame(PodiumDTO podiumDTO){
        result[0] = "Puesto 1: "+podiumDTO.getFirstPlace()+
                "\nPuesto 2: "+podiumDTO.getSecondPlace()+
                "\nPuesto 3: "+podiumDTO.getThirdPlace();

        return Mono.just(podiumDTO);
    }
}
