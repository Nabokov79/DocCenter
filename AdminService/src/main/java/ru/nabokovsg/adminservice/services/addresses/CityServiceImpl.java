package ru.nabokovsg.adminservice.services.addresses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.addresses.citys.CityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.NewCityDto;
import ru.nabokovsg.adminservice.dtos.addresses.citys.UpdateCityDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.addresses.CityMapper;
import ru.nabokovsg.adminservice.models.addresses.City;
import ru.nabokovsg.adminservice.repositoryes.addresses.CityRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final CityMapper mapper;

    @Override
    public CityDto save(NewCityDto cityDto) {
        if (repository.existsByName(cityDto.getName())) {
            throw new BadRequestException(String.format("city=%s found.", cityDto.getName()));
        }
        return mapper.mapToCityDto(repository.save(mapper.mapToNewCity(cityDto)));
    }

    @Override
    public CityDto update(UpdateCityDto cityDto) {
        if (!repository.existsById(cityDto.getId())) {
            throw new NotFoundException(String.format("city with id=%s not found for update.", cityDto.getId()));
        }
        return mapper.mapToCityDto(repository.save(mapper.mapToUpdateCity(cityDto)));
    }

    @Override
    public List<CityDto> getAll() {
        return mapper.mapToAuthorsDto(repository.findAll());
    }

    @Override
    public String delete(Long citId) {
        City city = repository.findById(citId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("city with id=%s not found for delete.", citId))
                );
        repository.deleteById(citId);
        return city.getName();
    }
}
