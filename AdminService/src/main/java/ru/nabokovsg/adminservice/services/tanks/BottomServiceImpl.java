package ru.nabokovsg.adminservice.services.tanks;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.BottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.NewBottomDto;
import ru.nabokovsg.adminservice.dtos.tanks.bottoms.UpdateBottomDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.tanks.BottomMapper;
import ru.nabokovsg.adminservice.models.tanks.Bottom;
import ru.nabokovsg.adminservice.models.tanks.QBottom;
import ru.nabokovsg.adminservice.repositoryes.tanks.BottomRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BottomServiceImpl implements BottomService {

    private final BottomRepository repository;
    private final BottomMapper mapper;
    private final EntityManager entityManager;

    @Override
    public List<BottomDto> save(List<NewBottomDto> bottomsDto) {
        List<Bottom> bottoms = mapper.mapToNewBottoms(bottomsDto);
        return mapper.mapToBottomsDto(repository.saveAll(bottoms));
    }

    @Override
    public List<BottomDto> update(List<UpdateBottomDto> bottomsDto) {
        List<Long> ids = new ArrayList<>(bottomsDto.stream().map(UpdateBottomDto::getId).toList());
        ids.removeIf(repository.findAllById(ids).stream().map(Bottom::getId).toList()::contains);
        if (ids.size() > 0) {
            throw new NotFoundException(String.format("Bottoms with ids=%s not found",ids));
        }
        List<Bottom> bottoms = mapper.mapToUpdateBottoms(bottomsDto);
        return mapper.mapToBottomsDto(repository.saveAll(bottoms));
    }

    @Override
    public List<BottomDto> getAll(Integer thickness, Integer thicknessEdge, Long tankParametersId) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(thickness != null) {
            booleanBuilder.and(QBottom.bottom.thicknessBottom.eq(thickness));
        }
        if(thicknessEdge != null) {
            booleanBuilder.and(QBottom.bottom.thicknessEdge.eq(thicknessEdge));
        }
        if (tankParametersId != null) {
            booleanBuilder.and(QBottom.bottom.tankParameters.id.eq(tankParametersId));
        }
        QBottom bottom = QBottom.bottom;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<Bottom> query = qf.from(bottom)
                .select(bottom)
                .where(booleanBuilder);
        return mapper.mapToBottomsDto(query.fetch());
    }

    @Override
    public void delete(Long botId) {
        if (repository.existsById(botId)) {
            repository.deleteById(botId);
        }
        throw new NotFoundException(String.format("bottom with id = %s not found for delete", botId));
    }
}
