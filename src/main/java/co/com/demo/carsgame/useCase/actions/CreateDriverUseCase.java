package co.com.demo.carsgame.useCase.actions;

import co.com.demo.carsgame.dto.DriverDTO;
import co.com.demo.carsgame.mapper.DriverMapper;
import co.com.demo.carsgame.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateDriverUseCase {
    private final DriverRepository driverDTORepository;
    private final DriverMapper driverMapper;

    @Autowired
    public CreateDriverUseCase(DriverRepository driverDTORepository, DriverMapper driverMapper) {
        this.driverDTORepository = driverDTORepository;
        this.driverMapper = driverMapper;
    }

    public Mono<DriverDTO> apply(DriverDTO driverDTO) {
        return driverDTORepository
                .save(driverDTO)
                .thenReturn(driverDTO);
    }
}