package co.com.demo.carsgame.useCase.queries;

import co.com.demo.carsgame.dto.DriverDTO;
import co.com.demo.carsgame.mapper.DriverMapper;
import co.com.demo.carsgame.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdDriverUseCase {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public FindByIdDriverUseCase(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public Mono<DriverDTO> findByIdDriver(String id) {
        return driverRepository.findById(id)
                .flatMap(
                        driver -> Mono.just(driverMapper.mapperToDriverDTO().apply(driver))
                );
    }
}
