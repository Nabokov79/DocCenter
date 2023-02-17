package ru.nabokovsg.adminservice.services.pipelines;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.models.Type;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.pipelines.PipelineIdsDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.pipelines.PipelineMapper;
import ru.nabokovsg.adminservice.models.pipelines.OilPipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;
import ru.nabokovsg.adminservice.repositoryes.pipelines.StandardNormPipeRepository;
import ru.nabokovsg.adminservice.services.common.CommonService;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PipeLineServiceImpl implements PipeLineService {

    private final StandardNormPipeRepository standardNormPipeRepository;
    private final CommonService commonService;
    private final PipelineMapper mapper;

    @Override
    public PipelinePassport setValuePipeline(PipelinePassport passportDto, PipelineIdsDto ids, RequestIds requestIds) {
        CommonDto commonDto = commonService.getObjects(requestIds);
        PipelinePassport passport = mapper.mapToPipelinePassport(passportDto, commonDto);
        passport.setType(commonService.getType(ids.getTypeId()));
        passport.setStandardNormPipes(getStandardNormPipe(ids.getStandardNormPipesId()));
        return passport;
    }

    @Override
    public OilPipelinePassport setValueOilPipeline(OilPipelinePassport passportDto, PipelineIdsDto ids, RequestIds requestIds) {
        CommonDto commonDto = commonService.getObjects(requestIds);
        OilPipelinePassport passport = mapper.mapToOilPipelinePassport(passportDto, commonDto);
        passport.setType(commonService.getType(ids.getTypeId()));
        passport.setStandardNormPipes(getStandardNormPipe(ids.getStandardNormPipesId()));
        return passport;
    }

    @Override
    public List<StandardNormPipe> setTypePipeline(List<StandardNormPipe> pipes, List<Long> ids) {
        if (ids.size() != 1) {
            throw new BadRequestException(
                    String.format("number of pipeline objects is not equal to 1 quantity=%s, ids=%s", ids.size(), ids));
        }
        Type type = commonService.getType(ids.get(0));
        for (StandardNormPipe pipe : pipes) {
            pipe.setType(type);
        }
        return pipes;
    }

    private List<StandardNormPipe> getStandardNormPipe(List<Long> ids) {
        Map<Long, StandardNormPipe> standardNormPipes = standardNormPipeRepository.findAllById(ids)
                .stream().collect(Collectors.toMap(StandardNormPipe::getId, s -> s));
        if (standardNormPipes.size() != ids.size() || standardNormPipes.isEmpty()) {
            java.util.List<Long> idsDb = new ArrayList<>(standardNormPipes.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("standard and norm Pipes with id= %s not found", ids));
        }
        return new ArrayList<>(standardNormPipes.values());
    }
}
