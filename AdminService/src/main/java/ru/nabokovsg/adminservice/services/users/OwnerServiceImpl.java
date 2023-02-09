package ru.nabokovsg.adminservice.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.users.NewOwnerDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateOwnerDto;
import ru.nabokovsg.adminservice.dtos.users.OwnerDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.users.OwnerMapper;
import ru.nabokovsg.adminservice.models.users.Owner;
import ru.nabokovsg.adminservice.repositoryes.users.OwnerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository repository;
    private final OwnerMapper mapper;

    @Override
    public OwnerDto save(NewOwnerDto ownerDto) {
        if (repository.existsByName(ownerDto.getName())) {
            throw new BadRequestException(
                    String.format("owner with name=%s found.", ownerDto.getName())
            );
        }
        Owner owner = mapper.mapToNewOwner(ownerDto);
        return mapper.mapToOwnerDto(repository.save(owner));
    }

    @Override
    public OwnerDto update(UpdateOwnerDto ownerDto) {
        if (!repository.existsById(ownerDto.getId())) {
            throw new NotFoundException(
                    String.format("owner with name=%s not found for update.", ownerDto.getName())
            );
        }
        Owner owner = mapper.mapToUpdateOwner(ownerDto);
        return mapper.mapToOwnerDto(repository.save(owner));
    }

    @Override
    public List<OwnerDto> getAll() {
        return mapper.mapToOwnersDto(repository.findAll());
    }

    @Override
    public String delete(Long ownId) {
        Owner owner = repository.findById(ownId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("owner with id=%s not found for delete.", ownId))
                );
        repository.deleteById(ownId);
        return owner.getName();
    }
}
