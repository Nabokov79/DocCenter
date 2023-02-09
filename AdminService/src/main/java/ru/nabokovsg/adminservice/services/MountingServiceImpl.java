package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.mounting.MountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.NewMountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.UpdateMountingDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.MountingMapper;
import ru.nabokovsg.adminservice.models.Mounting;
import ru.nabokovsg.adminservice.repositoryes.MountingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MountingServiceImpl implements MountingService {

    private final MountingRepository repository;
    private final MountingMapper mapper;

    @Override
    public MountingDto save(NewMountingDto mountingDto) {
        if (repository.existsByName(mountingDto.getName())) {
            throw new BadRequestException(String.format("mounting=%s found.", mountingDto.getName()));
        }
        Mounting mounting = mapper.mapToNewMounting(mountingDto);
        return mapper.mapToMountingDto(repository.save(mounting));
    }

    @Override
    public MountingDto update(UpdateMountingDto mountingDto) {
        if (!repository.existsById(mountingDto.getId())) {
            throw new NotFoundException(String.format("mounting=%s not found for update.", mountingDto.getName()));
        }
        Mounting mounting = mapper.mapToUpdateMounting(mountingDto);
        return mapper.mapToMountingDto(repository.save(mounting));
    }

    @Override
    public List<MountingDto> getAll() {
        return mapper.mapToMountingsDto(repository.findAll());
    }

    @Override
    public String delete(Long mouId) {
        Mounting mounting = repository.findById(mouId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("mounting with id=%s not found for delete.", mouId))
                );
        repository.deleteById(mouId);
        return mounting.getName();
    }
}
