package ru.nabokovsg.adminservice.services.users;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.users.*;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;
import ru.nabokovsg.adminservice.models.users.QMeasuringTool;
import ru.nabokovsg.adminservice.repositoryes.*;
import ru.nabokovsg.adminservice.mappers.users.MeasuringToolMapper;
import ru.nabokovsg.adminservice.repositoryes.users.*;
import ru.nabokovsg.adminservice.services.common.CommonService;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasuringToolServiceImpl implements MeasuringToolService {

    private final MeasuringToolRepository repository;
    private final CommonService commonService;
    private final MeasuringToolMapper mapper;
    private final EntityManager entityManager;

    @Override
    public MeasuringToolDto save(NewMeasuringToolDto measuringToolDto) {
        if (measuringToolDto == null) {
            throw new NotFoundException("new measuring tool not found for save");
        }
        MeasuringTool measuringTool = commonService.setMeasuringToolValue(mapper.mapToNewMeasuringTool(measuringToolDto),
                                                                    mapper.mapToNeMeasuringToolValue(measuringToolDto));
        return mapper.mapToMeasuringToolDto(repository.save(measuringTool));
    }

    @Override
    public MeasuringToolDto update(UpdateMeasuringToolDto measuringToolDto) {
        if (!repository.existsById(measuringToolDto.getId())) {
            throw new NotFoundException(
                    String.format("measuring tool with id = %s not found for update", measuringToolDto.getId())
            );
        }
        MeasuringTool measuringTool = commonService.setMeasuringToolValue(
                                                                mapper.mapToUpdateMeasuringTool(measuringToolDto),
                                                                mapper.mapToUpdateMeasuringToolValue(measuringToolDto)
                                                                );
        return mapper.mapToMeasuringToolDto(repository.save(measuringTool));
    }

    @Override
    public List<MeasuringToolDto> getAll(RequestParameters parameters) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(parameters.getName() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.name.eq(parameters.getName()));
        }
        if(parameters.getModel() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.model.eq(parameters.getModel()));
        }
        if (parameters.getWorkNumber() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.workNumber.eq(parameters.getWorkNumber()));
        }
        if (parameters.getManufacturing() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.manufacturing.after(parameters.getManufacturing()));
        }
        if (parameters.getExploitation() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.exploitation.eq(parameters.getManufacturing()));
        }
        if (parameters.getManufacturerId() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.manufacturer.id.eq(parameters.getManufacturerId()));
        }
        if (parameters.getOrganizationId() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.organization.id.eq(parameters.getOrganizationId()));
        }
        if (parameters.getTypeId() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.type.id.eq(parameters.getTypeId()));
        }
        if (parameters.getUserId() != null) {
            booleanBuilder.and(QMeasuringTool.measuringTool.user.id.eq(parameters.getUserId()));
        }
        QMeasuringTool measuringTool = QMeasuringTool.measuringTool;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<MeasuringTool> query = qf.from(measuringTool)
                .select(measuringTool)
                .where(booleanBuilder);
        return mapper.mapToMeasuringToolsDto(query.fetch());
    }

    @Override
    public void delete(Long meaId) {
        if (repository.existsById(meaId)) {
            repository.deleteById(meaId);
            return;
        }
        throw new NotFoundException(String.format("measuring tool with id = %s not found for delete", meaId));
    }


}
