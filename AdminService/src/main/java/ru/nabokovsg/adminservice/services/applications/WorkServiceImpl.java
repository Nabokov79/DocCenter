package ru.nabokovsg.adminservice.services.applications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.applications.NewWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.UpdateWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.WorkDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.applications.WorkMapper;
import ru.nabokovsg.adminservice.models.applications.Work;
import ru.nabokovsg.adminservice.repositoryes.applications.WorkRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {

    private final WorkRepository repository;
    private final WorkMapper mapper;

    @Override
    public WorkDto save(NewWorkDto workDto) {
        if (repository.existsByName(workDto.getName())) {
            throw new BadRequestException(String.format("work=%s found", workDto.getName()));
        }
        Work work = mapper.mapToNewWork(workDto);
        return mapper.mapToWorkDto(repository.save(work));
    }

    @Override
    public WorkDto update(UpdateWorkDto workDto) {
        if (!repository.existsById(workDto.getId())) {
            throw new NotFoundException(String.format("work=%s not found for update.", workDto.getName()));
        }
        Work work = mapper.mapToUpdateWork(workDto);
        return mapper.mapToWorkDto(repository.save(work));
    }

    @Override
    public List<WorkDto> getAll() {
        return mapper.mapToWorksDto(repository.findAll());
    }

    @Override
    public void delete(Long worId) {
        if (repository.existsById(worId)) {
            repository.deleteById(worId);
        }
        throw new NotFoundException(String.format("work with id=%s not found for delete.", worId));
    }
}
