package ru.nabokovsg.adminservice.services.pipelines;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.NewStandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.StandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.UpdateStandardNormPipeDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.pipelines.StandardNormPipeMapper;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;
import ru.nabokovsg.adminservice.repositoryes.pipelines.PurposePipelineRepository;
import ru.nabokovsg.adminservice.repositoryes.pipelines.StandardNormPipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StandardNormPipeServiceImpl implements StandardNormPipeService {

    private final StandardNormPipeRepository repository;
    private final PurposePipelineRepository purposePipelineRepository;
    private final PipeLineService service;
    private final StandardNormPipeMapper mapper;

    @Override
    public List<StandardNormPipeDto> save(List<NewStandardNormPipeDto> pipesDto) {
        List<Long> purposeIds = pipesDto.stream().map(NewStandardNormPipeDto::getPurposePipelineId).distinct().toList();
        List<StandardNormPipe> standardPipes = service.setPurposePipeline(mapper.mapToNewStandardNormPipe(pipesDto), purposeIds);
        PurposePipeline purposePipelines = standardPipes.stream().map(StandardNormPipe::getPurpose).toList().get(0);
        List<StandardNormPipe> standardPipesDb = repository.findAllByPurpose(purposePipelines);
        standardPipes = standardPipes.stream().filter(p -> !standardPipesDb.contains(p)).toList();
        if (standardPipes.isEmpty()) {
            throw new BadRequestException(String.format("standard and norm pipe found %s.", pipesDto));
        }
        return mapper.mapToStandardNormPipesDto(repository.saveAll(standardPipes));
    }

    @Override
    public List<StandardNormPipeDto> update(List<UpdateStandardNormPipeDto> pipesDto) {
        List<StandardNormPipe> updateStandardPipes = mapper.mapToUpdateStandardNormPipe(pipesDto);
        List<Long> ids = updateStandardPipes.stream().map(StandardNormPipe:: getId).toList();
        List<StandardNormPipe> updateStandardPipesDb = repository.findAllById(ids);
        if (updateStandardPipes.size() != updateStandardPipesDb.size() || updateStandardPipesDb.isEmpty()) {
            updateStandardPipes = updateStandardPipes.stream().filter(p -> !updateStandardPipesDb.contains(p)).toList();
            throw new NotFoundException(
                                 String.format("standard and norm pipe not found for update %s.", updateStandardPipes));
        }
        List<Long> purposeIds = pipesDto.stream().map(UpdateStandardNormPipeDto::getPurposePipelineId).distinct().toList();
        if (purposeIds.size() != 1) {
            throw new BadRequestException(
                    String.format("number of pipeline objects is not equal to 1 quantity=%s, ids=%s", purposeIds.size()
                                                                                                    ,purposeIds));
        }
        return mapper.mapToStandardNormPipesDto(
                repository.saveAll(service.setPurposePipeline(updateStandardPipes, purposeIds))
        );
    }

    @Override
    public List<StandardNormPipeDto> getAll(Long purposePipelineId) {
        PurposePipeline purposePipeline = purposePipelineRepository.findById(purposePipelineId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("purpose pipeline with id=%s not found", purposePipelineId)));
        return mapper.mapToStandardNormPipesDto(repository.findAllByPurpose(purposePipeline));
    }

    @Override
    public void delete(Long staId) {
        if (repository.existsById(staId)) {
            repository.deleteById(staId);
        }
        throw new NotFoundException(String.format("standard and norm pipe with id=%s not found for delete.", staId));
    }


}
