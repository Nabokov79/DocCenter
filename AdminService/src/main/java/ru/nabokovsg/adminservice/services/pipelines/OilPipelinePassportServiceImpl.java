package ru.nabokovsg.adminservice.services.pipelines;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.pipelines.*;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.NewOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.OilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.ShortOilPipelinePassportDto;
import ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline.UpdateOilPipelinePassportDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.pipelines.OilPipelinePassportMapper;
import ru.nabokovsg.adminservice.models.pipelines.OilPipelinePassport;
import ru.nabokovsg.adminservice.repositoryes.pipelines.OilPipelinePassportRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OilPipelinePassportServiceImpl implements OilPipelinePassportService {

    private final OilPipelinePassportRepository repository;
    private final OilPipelinePassportMapper mapper;
    private final PipeLineService service;

    @Override
    public OilPipelinePassportDto save(NewOilPipelinePassportDto passportDto) {
        PipelineIdsDto ids = mapper.mapToNewPipelineIdsDto(passportDto);
        RequestIds requestIds = mapper.mapToNewOilRequestIdsDto(passportDto);
        OilPipelinePassport passport = service.setValueOilPipeline(
                mapper.mapToNewOilPipelinePassport(passportDto), ids, requestIds);
        if (repository.existsByAddress(passport.getAddress())) {
            throw new NotFoundException(String.format("pipeline passport=%s found", passport));
        }
        return mapper.mapToOilPipelinePassportDto(repository.save(passport));
    }

    @Override
    public OilPipelinePassportDto update(UpdateOilPipelinePassportDto passportDto) {
        if (!repository.existsById(passportDto.getId())) {
            throw new NotFoundException(
                    String.format("oil pipeline passport with id=%s not found for update.", passportDto.getId()));
        }
        PipelineIdsDto ids = mapper.mapToUpdatePipelineIdsDto(passportDto);
        RequestIds requestIds = mapper.mapToUpdateRequestIdsDto(passportDto);
        OilPipelinePassport passport = service.setValueOilPipeline(
                mapper.mapToUpdateOilPipelinePassport(passportDto), ids, requestIds);
        return mapper.mapToOilPipelinePassportDto(repository.save(passport));
    }

    @Override
    public OilPipelinePassportDto get(Long pasId) {
        return mapper.mapToOilPipelinePassportDto(repository.findById(pasId).orElseThrow(() ->  new NotFoundException(
                String.format("oil pipeline passport with id=%s not found for update.", pasId))));
    }

    @Override
    public List<ShortOilPipelinePassportDto> getAll() {
        return mapper.mapToShortOilPipelinePassportDto(repository.findAll());
    }

    @Override
    public void delete(Long pasId) {
        if (repository.existsById(pasId)) {
            repository.deleteById(pasId);
        }
        throw new NotFoundException(String.format("oil pipeline passport with id=%s not found for delete", pasId));
    }
}
