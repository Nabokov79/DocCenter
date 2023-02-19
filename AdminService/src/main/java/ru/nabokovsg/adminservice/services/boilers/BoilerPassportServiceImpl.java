package ru.nabokovsg.adminservice.services.boilers;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.CommonDto;
import ru.nabokovsg.adminservice.dtos.RequestIds;
import ru.nabokovsg.adminservice.dtos.boilers.BoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.NewBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.ShortBoilerPassportDto;
import ru.nabokovsg.adminservice.dtos.boilers.UpdateBoilerPassportDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.boilers.BoilerPassportMapper;
import ru.nabokovsg.adminservice.models.boilers.BoilerPassport;
import ru.nabokovsg.adminservice.models.boilers.QBoilerPassport;
import ru.nabokovsg.adminservice.repositoryes.boilers.BoilerPassportRepository;
import ru.nabokovsg.adminservice.repositoryes.boilers.BoilerRepository;
import ru.nabokovsg.adminservice.services.common.CommonService;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoilerPassportServiceImpl implements BoilerPassportService {

    private final BoilerPassportRepository repository;
    private final BoilerRepository boilerRepository;
    private final BoilerPassportMapper mapper;
    private final CommonService commonService;
    private final EntityManager entityManager;

    @Override
    public BoilerPassportDto save(NewBoilerPassportDto passportDto) {
        RequestIds requestIds = mapper.mapToNewRequestIdsDto(passportDto);
        BoilerPassport passport = setValues(mapper.mapToNewBoilerPassport(passportDto),
                                            passportDto.getBoilerId(),
                                            requestIds);
        if (repository.existsByBoilerAndAddress(passport.getBoiler(), passport.getAddress())) {
            throw new BadRequestException(String.format("boiler passport =%s found", passportDto));
        }
        return mapper.mapToBoilerPassportDto(repository.save(passport));
    }

    @Override
    public BoilerPassportDto update(UpdateBoilerPassportDto passportDto) {
        if (!repository.existsById(passportDto.getId())) {
            throw new NotFoundException(
                    String.format("boiler passport with id=%s not found for update", passportDto.getId()));
        }
        RequestIds requestIds = mapper.mapToUpdateRequestIdsDto(passportDto);
        BoilerPassport passport = setValues(mapper.mapToUpdateBoilerPassport(passportDto),
                passportDto.getBoilerId(),
                requestIds);
        return mapper.mapToBoilerPassportDto(repository.save(passport));
    }

    @Override
    public BoilerPassportDto get(Long pasId) {
        return mapper.mapToBoilerPassportDto(repository.findById(pasId)
                .orElseThrow(() -> new NotFoundException(
                String.format("boiler passport with id=%s not found for update", pasId))));
    }

    @Override
    public List<ShortBoilerPassportDto> getAll(Long boilerId, Long addressId) {
        if (boilerId == null && addressId == null) {
            return mapper.mapToShortBoilerPassportsDto(repository.findAll());
        }
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (boilerId != null) {
            booleanBuilder.and(QBoilerPassport.boilerPassport.boiler.id.eq(boilerId));
        }
        if (addressId != null) {
            booleanBuilder.and(QBoilerPassport.boilerPassport.address.id.eq(addressId));
        }
        QBoilerPassport boilerPassport = QBoilerPassport.boilerPassport;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<BoilerPassport> query = qf.from(boilerPassport)
                .select(boilerPassport)
                .where(booleanBuilder)
                .groupBy(boilerPassport.address);
        return mapper.mapToShortBoilerPassportsDto(query.fetch());
    }

    @Override
    public void delete(Long pasId) {
        if (repository.existsById(pasId)) {
            repository.deleteById(pasId);
            return;
        }
        throw new NotFoundException(String.format("boiler passport with id=%s not found for delete", pasId));
    }

    private BoilerPassport setValues(BoilerPassport passport, Long boilerId, RequestIds requestIds) {
        CommonDto common = commonService.getObjects(requestIds);
       if (boilerId != null) {
           passport.setBoiler(boilerRepository.findById(boilerId)
                   .orElseThrow(() -> new NotFoundException(
                           String.format("boiler with id=%s not found for set passport", boilerId))));
       }
        return mapper.mapToBoilerPassport(passport, common);
    }}
