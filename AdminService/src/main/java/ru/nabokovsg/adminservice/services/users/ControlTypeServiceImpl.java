package ru.nabokovsg.adminservice.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.users.ControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.NewControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateControlTypeDto;
import ru.nabokovsg.adminservice.mappers.users.ControlTypeMapper;
import ru.nabokovsg.adminservice.repositoryes.users.ControlTypeRepository;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.users.ControlType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ControlTypeServiceImpl implements ControlTypeService {

    private final ControlTypeRepository repository;
    private final ControlTypeMapper mapper;

    @Override
    public ControlTypeDto save(NewControlTypeDto typeControlDto) {
        if (repository.existsByName(typeControlDto.getName())) {
            throw new BadRequestException(
                    String.format("control type=%s found.", typeControlDto.getName())
            );
        }
        ControlType typeControl = mapper.mapToNewControlType(typeControlDto);
        typeControl.setName(typeControl.getName().toUpperCase());
        return mapper.mapToControlTypeDto(repository.save(typeControl));
    }

    @Override
    public ControlTypeDto update(UpdateControlTypeDto typeControlDto) {
        if (!repository.existsById(typeControlDto.getId())) {
            throw new NotFoundException(
                    String.format("control type=%s not found for update.", typeControlDto.getName())
            );
        }
        ControlType typeControl = mapper.mapToUpdateControlType(typeControlDto);
        return mapper.mapToControlTypeDto(repository.save(typeControl));
    }

    @Override
    public List<ControlTypeDto> getAll() {
        return mapper.mapToControlTypesDto(repository.findAll());
    }

    @Override
    public String delete(Long typId) {
        ControlType typeControl = repository.findById(typId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("control type with id=%s not found for delete.", typId))
                );
        repository.deleteById(typId);
        return typeControl.getName();
    }
}
