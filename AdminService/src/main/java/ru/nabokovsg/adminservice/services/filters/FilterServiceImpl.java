package ru.nabokovsg.adminservice.services.filters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.filters.Filter;
import ru.nabokovsg.adminservice.dtos.filters.FilterDto;
import ru.nabokovsg.adminservice.dtos.filters.NewFilterDto;
import ru.nabokovsg.adminservice.dtos.filters.UpdateFilterDto;
import ru.nabokovsg.adminservice.mappers.filters.FilterMapper;
import ru.nabokovsg.adminservice.models.filters.Type;
import ru.nabokovsg.adminservice.repositoryes.filters.FilterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final FilterRepository repository;
    private final FilterMapper mapper;

    @Override
    public FilterDto save(NewFilterDto filterDto) {
        if (repository.existsByNameAndModel(filterDto.getName(), filterDto.getModel())) {
            throw new BadRequestException(String.format("filter=%s found", filterDto));
        }
        Filter filter = setLetterCase(mapper.mapToNewFilter(filterDto));
        filter.setType(getType(filterDto.getType()));
        return mapper.mapToFilterDto(repository.save(filter));
    }

    @Override
    public FilterDto update(UpdateFilterDto filterDto) {
        if (!repository.existsById(filterDto.getId())) {
            throw new NotFoundException(String.format("filter with id=%s not found for update", filterDto.getId()));
        }
        Filter filter = setLetterCase(mapper.mapToUpdateFilter(filterDto));
        filter.setType(getType(filterDto.getType()));
        return mapper.mapToFilterDto(repository.save(filter));
    }

    @Override
    public List<FilterDto> getAll() {
        return mapper.mapToFiltersDto(repository.findAll());
    }

    @Override
    public void delete(Long filId) {
        if (repository.existsById(filId)) {
            repository.deleteById(filId);
        }
        throw new NotFoundException(String.format("filter with id=%s not found for delete", filId));
    }

    private Filter setLetterCase(Filter filter) {
        if (filter.getName().length() <= 3) {
            filter.setName(filter.getName().toUpperCase());
        }
        if (!filter.getModel().isEmpty()) {
            filter.setModel(filter.getModel().toUpperCase());
        }
        return filter;
    }

    private Type getType(String type) {
        return Type.from(type)
                .orElseThrow(() -> new BadRequestException("Unknown type object: " + type));

    }
}
