package ru.nabokovsg.adminservice.services.tanks;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.tanks.belts.BeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.NewBeltDto;
import ru.nabokovsg.adminservice.dtos.tanks.belts.UpdateBeltDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.tanks.BeltMapper;
import ru.nabokovsg.adminservice.models.tanks.Belt;
import ru.nabokovsg.adminservice.models.tanks.QBelt;
import ru.nabokovsg.adminservice.repositoryes.tanks.BeltRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeltServiceImpl implements BeltService {

    private final BeltRepository repository;
    private final BeltMapper mapper;
    private final EntityManager entityManager;

    @Override
    public List<BeltDto> save(List<NewBeltDto> beltsDto) {
        List<Belt> belts = mapper.mapToNewBelts(beltsDto);
        return mapper.mapToBeltsDto(repository.saveAll(belts));
    }

    @Override
    public List<BeltDto> update(List<UpdateBeltDto> beltsDto) {
        List<Long> ids = new ArrayList<>(beltsDto.stream().map(UpdateBeltDto::getId).toList());
        ids.removeIf(repository.findAllById(ids).stream().map(Belt::getId).toList()::contains);
        if (ids.size() > 0) {
            throw new NotFoundException(String.format("Belts with ids=%s not found",ids));
        }
        List<Belt> belts = mapper.mapToUpdateBelts(beltsDto);
        return mapper.mapToBeltsDto(repository.saveAll(belts));
    }

    @Override
    public List<BeltDto> getAll(Integer thickness, Long tankParametersId) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(thickness != null) {
            booleanBuilder.and(QBelt.belt.thickness.eq(thickness));
        }
        if (tankParametersId != null) {
            booleanBuilder.and(QBelt.belt.tankParameters.id.eq(tankParametersId));
        }
        QBelt belt = QBelt.belt;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<Belt> query = qf.from(belt)
                .select(belt)
                .where(booleanBuilder);
        return mapper.mapToBeltsDto(query.fetch());
    }

    @Override
    public void delete(Long belId) {
        if (repository.existsById(belId)) {
            repository.deleteById(belId);
        }
        throw new NotFoundException(String.format("belt with id = %s not found for delete", belId));
    }
}
