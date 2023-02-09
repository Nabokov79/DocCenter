package ru.nabokovsg.adminservice.services.tanks;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.NewTankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.TankParametersDto;
import ru.nabokovsg.adminservice.dtos.tanks.tankParameters.UpdateTankParametersDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.mappers.tanks.TankParametersMapper;
import ru.nabokovsg.adminservice.models.tanks.Orientation;
import ru.nabokovsg.adminservice.models.tanks.TankParameters;
import ru.nabokovsg.adminservice.models.tanks.TypeTank;
import ru.nabokovsg.adminservice.repositoryes.tanks.TankParametersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TankParametersServiceImpl implements TankParametersService {

    private final TankParametersRepository repository;
    private final TankParametersMapper mapper;

    @Override
    public TankParametersDto save(NewTankParametersDto tankParametersDto) {
        return mapper.mapToTankParametersDto(
                repository.save(setValues(mapper.mapToNewTankParameters(tankParametersDto),
                                          tankParametersDto.getTypeTank(),
                                          tankParametersDto.getOrientation()))
        );
    }

    @Override
    public TankParametersDto update(UpdateTankParametersDto tankParametersDto) {
        if (!repository.existsById(tankParametersDto.getId())) {
            throw new BadRequestException(
                    String.format("tank parameters with id=%s not found for update", tankParametersDto.getId()));
        }
        return mapper.mapToTankParametersDto(
                repository.save(setValues(mapper.mapToUpdateTankParameters(tankParametersDto),
                                         tankParametersDto.getTypeTank(),
                                         tankParametersDto.getOrientation())));
    }

    @Override
    public List<TankParametersDto> getAll() {
        return mapper.mapToTankParametersDto(repository.findAll());
    }

    @Override
    public void delete(Long parId) {
        if (repository.existsById(parId)) {
            repository.deleteById(parId);
        }
        throw new BadRequestException(String.format("tank parameters with id=%s not found for update", parId));
    }

    private TankParameters setValues(TankParameters parameters, String typeTank, String orientation) {
        parameters.setTypeTank(TypeTank.from(typeTank)
                .orElseThrow(() -> new BadRequestException("Unknown type object: " + typeTank)));
        parameters.setOrientation(Orientation.from(orientation)
                .orElseThrow(() -> new BadRequestException("Unknown type object: " + orientation)));
        return parameters;
    }
}
