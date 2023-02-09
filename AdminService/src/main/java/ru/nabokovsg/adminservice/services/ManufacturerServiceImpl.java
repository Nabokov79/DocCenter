package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.manufacturers.ManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.NewManufacturerDto;
import ru.nabokovsg.adminservice.dtos.manufacturers.UpdateManufacturerDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.ManufacturerMapper;
import ru.nabokovsg.adminservice.models.Manufacturer;
import ru.nabokovsg.adminservice.repositoryes.ManufacturerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository repository;
    private final ManufacturerMapper mapper;

    @Override
    public ManufacturerDto save(NewManufacturerDto manufacturerDto) {
        if (repository.existsByName(manufacturerDto.getName())) {
            throw new BadRequestException(
                    String.format("manufacturer=%s found.", manufacturerDto.getName())
            );
        }
        Manufacturer manufacturer = mapper.mapToNewManufacturer(manufacturerDto);
        return mapper.mapToManufacturerDto(repository.save(manufacturer));
    }

    @Override
    public ManufacturerDto update(UpdateManufacturerDto manufacturerDto) {
        if (!repository.existsById(manufacturerDto.getId())) {
            throw new NotFoundException(
                    String.format("manufacturer=%s not found for update.", manufacturerDto.getName())
            );
        }
        Manufacturer manufacturer = mapper.mapToUpdateManufacturer(manufacturerDto);
        return mapper.mapToManufacturerDto(repository.save(manufacturer));
    }

    @Override
    public List<ManufacturerDto> getAll() {
        return mapper.mapToManufacturersDto(repository.findAll());
    }

    @Override
    public String delete(Long manId) {
        Manufacturer manufacturer = repository.findById(manId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("manufacturer with id=%s not found for delete.", manId))
                );
        repository.deleteById(manId);
        return manufacturer.getName();
    }
}
