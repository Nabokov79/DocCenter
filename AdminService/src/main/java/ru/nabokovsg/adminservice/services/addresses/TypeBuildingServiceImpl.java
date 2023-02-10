package ru.nabokovsg.adminservice.services.addresses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.NewTypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.TypeBuildingDto;
import ru.nabokovsg.adminservice.dtos.addresses.typeBuilding.UpdateTypeBuildingDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.addresses.TypeBuildingMapper;
import ru.nabokovsg.adminservice.models.addresses.TypeBuilding;
import ru.nabokovsg.adminservice.repositoryes.addresses.TypeBuildingRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeBuildingServiceImpl implements TypeBuildingService {

    private final TypeBuildingRepository repository;
    private final TypeBuildingMapper mapper;


    @Override
    public TypeBuildingDto save(NewTypeBuildingDto typeBuildingDto) {
        if (repository.existsByName(typeBuildingDto.getName())) {
            throw new BadRequestException(String.format("type building=%s found.", typeBuildingDto.getName()));
        }
        TypeBuilding typeBuilding = setLetterCase(mapper.mapToNewTypeBuilding(typeBuildingDto));
        log.info("Type Building = " + typeBuilding);
        return mapper.mapToTypeBuildingDto(repository.save(typeBuilding));
    }

    @Override
    public TypeBuildingDto update(UpdateTypeBuildingDto typeBuildingDto) {
        if (!repository.existsById(typeBuildingDto.getId())) {
            throw new NotFoundException(
                    String.format("type building=%s not found for update.", typeBuildingDto.getName())
            );
        }
        TypeBuilding typeBuilding = setLetterCase(mapper.mapToUpdateTypeBuilding(typeBuildingDto));
        return mapper.mapToTypeBuildingDto(repository.save(setLetterCase(typeBuilding)));
    }

    @Override
    public List<TypeBuildingDto> getAll() {
        return mapper.mapToTypeBuildingsDto(repository.findAll());
    }

    @Override
    public void delete(Long buiId) {
        if (repository.existsById(buiId)) {
            log.info("ID = {}",buiId);
            repository.deleteById(buiId);
            return;
        }
        throw new NotFoundException(String.format("type building with id=%s not found for delete.", buiId));
    }

    private TypeBuilding setLetterCase(TypeBuilding typeBuilding) {
        if (typeBuilding.getName().length() <= 3) {
           typeBuilding.setName(typeBuilding.getName().toUpperCase());
        }
        return typeBuilding;
    }
}
