package ru.nabokovsg.adminservice.services.tanks;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.tanks.protections.NewProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.ProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.UpdateProtectionsDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.tanks.ProtectionsMapper;
import ru.nabokovsg.adminservice.models.tanks.Protections;
import ru.nabokovsg.adminservice.repositoryes.tanks.ProtectionsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProtectionsServiceImpl implements ProtectionsService {

    private final ProtectionsRepository repository;
    private final ProtectionsMapper mapper;

    @Override
    public ProtectionsDto save(NewProtectionsDto protectionsDto) {
        Protections protections = mapper.mapToNewProtections(protectionsDto);
        return mapper.mapToProtectionsDto(repository.save(protections));
    }

    @Override
    public ProtectionsDto update(UpdateProtectionsDto protectionsDto) {
        if (!repository.existsById(protectionsDto.getId())) {
            throw new NotFoundException(
                    String.format("Protections with id=%s not found for update", protectionsDto.getId()));
        }
        Protections protections = mapper.mapToUpdateProtections(protectionsDto);
        return mapper.mapToProtectionsDto(repository.save(protections));
    }

    @Override
    public List<ProtectionsDto> getAll() {
        return mapper.mapToProtectionsDto(repository.findAll());
    }

    @Override
    public void delete(Long proId) {
        if (repository.existsById(proId)) {
            repository.deleteById(proId);
        }
        throw new NotFoundException(String.format("Protections with id=%s not found for delete", proId));
    }
}
