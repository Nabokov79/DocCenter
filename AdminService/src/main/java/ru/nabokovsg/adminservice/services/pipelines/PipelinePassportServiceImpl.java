package ru.nabokovsg.adminservice.services.pipelines;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.pipelines.*;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.pipelines.PipelinePassportMapper;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.QPipelinePassport;
import ru.nabokovsg.adminservice.repositoryes.pipelines.PipelinePassportRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PipelinePassportServiceImpl implements PipelinePassportService {

    private final PipelinePassportRepository repository;
    private final PipelinePassportMapper mapper;
    private final PipeLineService service;
    private final EntityManager entityManager;


    @Override
    public PipelinePassportDto save(NewPipelinePassportDto passportDto) {
        PipelineIdsDto ids = mapper.mapToNewPipelineIdsDto(passportDto);
        RequestIds requestIds = mapper.mapToNewRequestIdsDto(passportDto);
        PipelinePassport passport = service.setValuePipeline(
                                                         mapper.mapToNewPipelinePassport(passportDto), ids, requestIds);
        if (repository.existsByTypeAndAddressAndLocation(passport.getType(),
                                                                    passport.getAddress(),
                                                                    passport.getLocation())) {
            throw new NotFoundException(String.format("pipeline passport =%s found", passport));
        }
        return mapper.mapToPipelinePassportDto(repository.save(passport));
    }

    @Override
    public PipelinePassportDto update(UpdatePipelinePassportDto passportDto) {
        if (!repository.existsById(passportDto.getId())) {
            throw new NotFoundException(
                            String.format("pipeline passport with id=%s not found for update.", passportDto.getId()));
        }
        PipelineIdsDto ids = mapper.mapToUpdatePipelineIdsDto(passportDto);
        RequestIds requestIds = mapper.mapToUpdateRequestIdsDto(passportDto);
        PipelinePassport passport = service.setValuePipeline(
                                                      mapper.mapToUpdatePipelinePassport(passportDto), ids, requestIds);
        return mapper.mapToPipelinePassportDto(repository.save(passport));
    }

    @Override
    public PipelinePassportDto get(Long pasId) {
        return mapper.mapToPipelinePassportDto(repository.findById(pasId).orElseThrow(() ->  new NotFoundException(
                String.format("pipeline passport with id=%s not found for update.", pasId))));
    }

    @Override
    public List<ShortPipelinePassportDto> getAll(Long typeId, Long addressId, String location) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (typeId != null) {
            booleanBuilder.and(QPipelinePassport.pipelinePassport.type.id.eq(typeId));
        }
        if (location != null) {
            booleanBuilder.and(QPipelinePassport.pipelinePassport.location.eq(location));
        }
        if (addressId != null) {
            booleanBuilder.and(QPipelinePassport.pipelinePassport.address.id.eq(addressId));
        }
        QPipelinePassport passports = QPipelinePassport.pipelinePassport;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<PipelinePassport> query = qf.from(passports)
                .select(passports)
                .where(booleanBuilder)
                .groupBy(passports.address);
        return mapper.mapToShortPipelinePassportDto(query.fetch());
    }

    @Override
    public void delete(Long pasId) {
        if (repository.existsById(pasId)) {
            repository.deleteById(pasId);
        }
        throw new NotFoundException(String.format("pipeline passport with id=%s not found for delete", pasId));
    }
}
