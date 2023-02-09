package ru.nabokovsg.adminservice.services.pipelines;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.NewPurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.PurposePipelineDto;
import ru.nabokovsg.adminservice.dtos.pipelines.purposePipeline.UpdatePurposePipelineDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.pipelines.PurposePipelineMapper;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;
import ru.nabokovsg.adminservice.repositoryes.pipelines.PurposePipelineRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurposePipelineServiceImpl implements PurposePipelineService {

    private final PurposePipelineRepository repository;
    private final PurposePipelineMapper mapper;

    @Override
    public PurposePipelineDto save(NewPurposePipelineDto purposePipeDto) {
        if (repository.existsByName(purposePipeDto.getName())) {
            throw new BadRequestException(String.format("purpose pipeline=%s found.", purposePipeDto.getName()));
        }
        PurposePipeline purposePipeline = mapper.mapToNewPurposePipeline(purposePipeDto);
        purposePipeline.setName(purposePipeline.getName().toLowerCase());
        return mapper.mapToPurposePipelineDto(repository.save(purposePipeline));
    }

    @Override
    public PurposePipelineDto update(UpdatePurposePipelineDto purposePipeDto) {
        if (!repository.existsById(purposePipeDto.getId())) {
            throw new NotFoundException(
                    String.format("purpose pipeline=%s not found for update.", purposePipeDto.getName())
            );
        }
        PurposePipeline purposePipeline = mapper.mapToUpdatePurposePipeline(purposePipeDto);
        purposePipeline.setName(purposePipeline.getName().toLowerCase());
        return mapper.mapToPurposePipelineDto(repository.save(purposePipeline));
    }

    @Override
    public List<PurposePipelineDto> getAll() {
        return mapper.mapToPurposePipelinesDto(repository.findAll());
    }

    @Override
    public String delete(Long purId) {
        PurposePipeline purposePipeline = repository.findById(purId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("purpose pipeline purposePipeline with id=%s not found for delete.", purId))
                );
        repository.deleteById(purId);
        return purposePipeline.getName();
    }
}
