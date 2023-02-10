package ru.nabokovsg.adminservice.services.addresses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.NewTypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.TypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.UpdateTypeBuildingDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.addresses.TypeBuildingMapper;
import ru.nabokovsg.adminservice.repositoryes.addresses.TypeBuildingRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeBuildingServiceImpl implements TypeBuildingService {

    private final TypeBuildingRepository repository;
    private final TypeBuildingMapper mapper;


    @Override
    public TypeBuildingDto save(NewTypeBuildingDto typeBuildingDto) {
        if (repository.existsByName(typeBuildingDto.getName())) {
            throw new BadRequestException(String.format("type building=%s found.", typeBuildingDto.getName()));
        }
        return mapper.mapToTypeBuildingDto(repository.save(mapper.mapToNewTypeBuilding(typeBuildingDto)));
    }

    @Override
    public TypeBuildingDto update(UpdateTypeBuildingDto typeBuildingDto) {
        if (!repository.existsById(typeBuildingDto.getId())) {
            throw new NotFoundException(
                    String.format("type building=%s not found for update.", typeBuildingDto.getName()));
        }
        return mapper.mapToTypeBuildingDto(repository.save(mapper.mapToUpdateTypeBuilding(typeBuildingDto)));
    }

    @Override
    public List<TypeBuildingDto> getAll() {
        return mapper.mapToTypeBuildingsDto(repository.findAll());
    }

    @Override
    public void delete(Long buiId) {
        if (repository.existsById(buiId)) {
            repository.deleteById(buiId);
            return;
        }
        throw new NotFoundException(String.format("type building with id=%s not found for delete.", buiId));
    }
}
