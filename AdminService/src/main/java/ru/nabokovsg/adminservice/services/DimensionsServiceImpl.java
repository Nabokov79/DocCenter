package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.dimensions.DimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.NewDimensionsDto;
import ru.nabokovsg.adminservice.dtos.dimensions.UpdateDimensionsDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.DimensionsMapper;
import ru.nabokovsg.adminservice.models.Dimensions;
import ru.nabokovsg.adminservice.repositoryes.DimensionsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DimensionsServiceImpl implements  DimensionsService {

    private final DimensionsRepository repository;
    private final DimensionsMapper mapper;


    @Override
    public DimensionsDto save(NewDimensionsDto dimensionsDto) {
        Dimensions dimensions = mapper.mapToNewDimensions(dimensionsDto);
        return mapper.mapToDimensionsDto(repository.save(dimensions));
    }

    @Override
    public DimensionsDto update(UpdateDimensionsDto dimensionsDto) {
        Dimensions dimensions = mapper.mapToUpdateDimensions(dimensionsDto);
        return mapper.mapToDimensionsDto(repository.save(dimensions));
    }

    @Override
    public List<DimensionsDto> getAll() {
        return mapper.mapToDimensionsDto(repository.findAll());
    }

    @Override
    public void delete(Long dimId) {
        if (repository.existsById(dimId)) {
            repository.deleteById(dimId);
        }
        throw new NotFoundException(String.format("dimensions with id=%s not found for delete", dimId));

    }
}
