package ru.nabokovsg.adminservice.services.pipelines;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.Type;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.NewStandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.StandardNormPipeDto;
import ru.nabokovsg.adminservice.dtos.pipelines.standardNormPipe.UpdateStandardNormPipeDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.pipelines.StandardNormPipeMapper;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;
import ru.nabokovsg.adminservice.repositoryes.pipelines.StandardNormPipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StandardNormPipeServiceImpl implements StandardNormPipeService {

    private final StandardNormPipeRepository repository;
    private final PipeLineService service;
    private final StandardNormPipeMapper mapper;

    @Override
    public List<StandardNormPipeDto> save(List<NewStandardNormPipeDto> pipesDto) {
        List<Long> typeIds = pipesDto.stream().map(NewStandardNormPipeDto::getTypeId).distinct().toList();
        List<StandardNormPipe> standardPipes = service.setTypePipeline(mapper.mapToNewStandardNormPipe(pipesDto), typeIds);
        Type typePipelines = standardPipes.stream().map(StandardNormPipe::getType).toList().get(0);
        List<StandardNormPipe> standardPipesDb = repository.findAllByTypeId(typePipelines.getId());
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
        List<Long> typeIds = pipesDto.stream().map(UpdateStandardNormPipeDto::getTypeId).distinct().toList();
        if (typeIds.size() != 1) {
            throw new BadRequestException(
                    String.format("number of pipeline objects is not equal to 1 quantity=%s, ids=%s", typeIds.size()
                                                                                                    , typeIds));
        }
        return mapper.mapToStandardNormPipesDto(
                repository.saveAll(service.setTypePipeline(updateStandardPipes, typeIds))
        );
    }

    @Override
    public List<StandardNormPipeDto> getAll(Long typeId) {
        return mapper.mapToStandardNormPipesDto(repository.findAllByTypeId(typeId));
    }

    @Override
    public void delete(Long staId) {
        if (repository.existsById(staId)) {
            repository.deleteById(staId);
        }
        throw new NotFoundException(String.format("standard and norm pipe with id=%s not found for delete.", staId));
    }


}
