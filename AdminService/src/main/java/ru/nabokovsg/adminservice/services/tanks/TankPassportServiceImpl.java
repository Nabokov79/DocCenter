package ru.nabokovsg.adminservice.services.tanks;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.tanks.TankIdsDto;
import ru.nabokovsg.adminservice.dtos.tanks.passport.*;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.tanks.TankPassportMapper;
import ru.nabokovsg.adminservice.models.Dimensions;
import ru.nabokovsg.adminservice.models.tanks.*;
import ru.nabokovsg.adminservice.repositoryes.DimensionsRepository;
import ru.nabokovsg.adminservice.repositoryes.tanks.*;
import ru.nabokovsg.adminservice.services.common.CommonService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TankPassportServiceImpl implements TankPassportService {

    private final TankPassportRepository repository;
    private final TankParametersRepository parametersRepository;
    private final BeltRepository beltRepository;
    private final BottomRepository bottomRepository;
    private final ProtectionsRepository protectionsRepository;
    private final DimensionsRepository dimensionsRepository;
     private final TankPassportMapper mapper;
    private final CommonService commonService;
    private final EntityManager entityManager;

    @Override
    public TankPassportDto save(NewTankPassportDto passportDto) {
        TankIdsDto ids = mapper.mapToNewIdsDto(passportDto);
        RequestIds requestIds = mapper.mapToNewRequestIdsDto(passportDto);
        TankPassport tankPassport = setValues(mapper.mapToNewTankPassports(passportDto), ids, requestIds);
        return mapper.mapToTankPassportDto(repository.save(tankPassport));
    }

    @Override
    public TankPassportDto update(UpdateTankPassportDto passportDto) {
        if (!repository.existsById(passportDto.getId())) {
            throw new NotFoundException(String.format("city=%s not found for update.", passportDto.getId()));
        }
        TankIdsDto ids = mapper.mapToUpdateIdsDto(passportDto);
        RequestIds requestIds = mapper.mapToUpdateRequestIdsDto(passportDto);
        TankPassport tankPassport = setValues(mapper.mapToUpdateTankPassport(passportDto), ids, requestIds);

        return mapper.mapToTankPassportDto(repository.save(tankPassport));
    }

    @Override
    public TankPassportDto get(Long pasId) {
        return mapper.mapToTankPassportDto(repository.findById(pasId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("tank passport with id=%s not found for update", pasId))));
    }

    @Override
    public List<ShortTankPassportDto> getAll(TankSearchParam param) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (param.getTypeTank() != null) {
            booleanBuilder.and(QTankPassport.tankPassport.tankParameters.typeTank.eq(param.getTypeTank()));
        }
        if (param.getOrientation() != null) {
            booleanBuilder.and(QTankPassport.tankPassport.tankParameters.orientation.eq(param.getOrientation()));
        }
        if (param.getVolume() != null) {
            booleanBuilder.and(QTankPassport.tankPassport.tankParameters.volume.eq(param.getVolume()));
        }
        if (param.getAddressId() != null) {
            booleanBuilder.and(QTankPassport.tankPassport.address.id.eq(param.getAddressId()));
        }
        QTankPassport tankPassports = QTankPassport.tankPassport;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<TankPassport> query = qf.from(tankPassports)
                .select(tankPassports)
                .where(booleanBuilder)
                .groupBy(tankPassports.address)
                .orderBy(tankPassports.tankNumber.asc());
        return mapper.mapToShortTankPassportsDto(query.fetch());
        }

    @Override
    public void delete(Long pasId) {
        if (repository.existsById(pasId)) {
            repository.deleteById(pasId);
        }
        throw new NotFoundException(String.format("tank passport with id=%s not found for delete", pasId));
    }

    private TankPassport setValues(TankPassport passport, TankIdsDto ids, RequestIds requestIds) {
        CommonDto commonDto = commonService.getObjects(requestIds);
        if (ids.getTankParametersId() != null) {
            passport.setTankParameters(getTankParameters(ids.getTankParametersId()));
        }
        if (ids.getDimensionsId() != null) {
            passport.setDimensions(getDimensions(ids.getDimensionsId()));
        }
        if (ids.getProtectionsId() != null) {
            passport.setProtections(getProtections(ids.getProtectionsId()));
        }
        if (ids.getBeltsId() != null) {
            passport.setBelts(getBelts(ids.getBeltsId()));
        }
        if (ids.getBottomsId() != null) {
            passport.setBottoms(getBottoms(ids.getBottomsId()));
        }
        return mapper.mapToTankPassport(passport, commonDto);
    }

    private TankParameters getTankParameters(Long id) {
        return parametersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("tank parameters with id=%s not found", id)));
    }

    private List<Belt> getBelts(List<Long> ids) {
        Map<Long, Belt> belts = beltRepository.findAllById(ids).stream().collect(Collectors.toMap(Belt::getId, belt -> belt));
        if (belts.size() != ids.size() || belts.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(belts.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).toList();
            throw new NotFoundException(String.format("belts with id= %s not found", ids));
        }
        return new ArrayList<>(belts.values());

    }
    private List<Bottom> getBottoms(List<Long> ids) {
        Map<Long, Bottom> bottoms = bottomRepository.findAllById(ids).stream().collect(Collectors.toMap(Bottom::getId, bottom -> bottom));
        if (bottoms.size() != ids.size() || bottoms.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(bottoms.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).toList();
            throw new NotFoundException(String.format("bottoms with id= %s not found", ids));
        }
        return new ArrayList<>(bottoms.values());

    }

    private Protections getProtections(Long id) {
        return protectionsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("protections with id=%s not found", id)));
    }

    private Dimensions getDimensions(Long id) {
        return dimensionsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("dimensions with id=%s not found", id)));
    }
}
