package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.Type;
import ru.nabokovsg.adminservice.dtos.types.NewTypeDto;
import ru.nabokovsg.adminservice.dtos.types.TypeDto;
import ru.nabokovsg.adminservice.dtos.types.UpdateTypeDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.TypeMapper;
import ru.nabokovsg.adminservice.repositoryes.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository repository;
    private final TypeMapper mapper;

    @Override
    public TypeDto save(NewTypeDto typeDto) {
        if (repository.existsByName(typeDto.getName())) {
            throw new BadRequestException(String.format("type=%s found.", typeDto.getName()));
        }
        Type type = mapper.mapToNewType(typeDto);
        return mapper.mapToTypeDto(repository.save(type));
    }

    @Override
    public TypeDto update(UpdateTypeDto typeDto) {
        if (!repository.existsById(typeDto.getId())) {
            throw new NotFoundException(String.format("type=%s not found for update.", typeDto.getName()));
        }
        Type type = mapper.mapToUpdateType(typeDto);
        return mapper.mapToTypeDto(repository.save(type));
    }

    @Override
    public List<TypeDto> getAll() {
        return mapper.mapToTypesDto(repository.findAll());
    }
}
