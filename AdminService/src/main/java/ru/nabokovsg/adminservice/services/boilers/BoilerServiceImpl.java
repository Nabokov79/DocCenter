package ru.nabokovsg.adminservice.services.boilers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.boilers.BoilerMapper;
import ru.nabokovsg.adminservice.models.boilers.Boiler;
import ru.nabokovsg.adminservice.repositoryes.boilers.BoilerRepository;
import ru.nabokovsg.adminservice.services.common.CommonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoilerServiceImpl implements BoilerService {

    private final BoilerRepository repository;
    private final BoilerMapper mapper;
    private final CommonService commonService;

    @Override
    public BoilerDto save(NewBoilerDto boilerDto) {
        Boiler boiler = setValue(mapper.mapToNewBoiler(boilerDto), boilerDto.getTypeId());
        return mapper.mapToBoilerDto(repository.save(boiler));
    }

    @Override
    public BoilerDto update(UpdateBoilerDto boilerDto) {
        if (!repository.existsById(boilerDto.getId())) {
            throw new NotFoundException(String.format("boiler with id=%s not found for update", boilerDto.getId()));
        }
        Boiler boiler =  setValue(mapper.mapToUpdateBoiler(boilerDto), boilerDto.getTypeId());
        return mapper.mapToBoilerDto(repository.save(boiler));
    }

    @Override
    public List<BoilerDto> getAll() {
        return mapper.mapToBoilersDto(repository.findAll());
    }

    @Override
    public void delete(Long boiId) {
        if (repository.existsById(boiId)) {
            repository.deleteById(boiId);
        }
        throw new NotFoundException(String.format("boiler with id=%s not found for delete", boiId));
    }

    private Boiler setValue(Boiler boiler, Long typId) {
        boiler.setType(commonService.getType(typId));
        boiler.setModel(boiler.getModel().toUpperCase());
        return boiler;
    }
}
