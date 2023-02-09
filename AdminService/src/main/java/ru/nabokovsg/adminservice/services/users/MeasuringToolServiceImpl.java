package ru.nabokovsg.adminservice.services.users;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.users.MeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.NewMeasuringToolDto;
import ru.nabokovsg.adminservice.dtos.users.RequestParameters;
import ru.nabokovsg.adminservice.dtos.users.UpdateMeasuringToolDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;
import ru.nabokovsg.adminservice.models.users.QMeasuringTool;
import ru.nabokovsg.adminservice.repositoryes.*;
import ru.nabokovsg.adminservice.mappers.users.MeasuringToolMapper;
import ru.nabokovsg.adminservice.repositoryes.users.*;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasuringToolServiceImpl implements MeasuringToolService {

    private final MeasuringToolRepository repository;
    private final OrganizationRepository organizationRepository;
    private final ControlTypeRepository controlTypeRepository;
    private final UserRepository userRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final OwnerRepository ownerRepository;
    private final MeasuringToolMapper mapper;
    private final EntityManager entityManager;

    @Override
    public MeasuringToolDto save(NewMeasuringToolDto newMeasuringTool) {
        if (newMeasuringTool == null) {
            throw new NotFoundException("new measuring tool not found for save");
        }
        MeasuringTool measuringTool = mapper.mapToNewMeasuringTool(newMeasuringTool);
        getControlTypeRepositoryById(measuringTool,newMeasuringTool.getTypeId());
        getOrganizationById(measuringTool, newMeasuringTool.getOrganizationId());
        getUserById(measuringTool, newMeasuringTool.getUserId());
        getManufacturerById(measuringTool, newMeasuringTool.getManufacturerId());
        getOwnerById(measuringTool,newMeasuringTool.getOwnerId());
        return mapper.mapToMeasuringToolDto(repository.save(measuringTool));
    }

    @Override
    public MeasuringToolDto update(UpdateMeasuringToolDto updateMeasuringTool) {
        if (!repository.existsById(updateMeasuringTool.getId())) {
            throw new NotFoundException(
                    String.format("measuring tool with id = %s not found for update", updateMeasuringTool.getId())
            );
        }
        MeasuringTool measuringTool = mapper.mapToUpdateMeasuringTool(updateMeasuringTool);
        getControlTypeRepositoryById(measuringTool,updateMeasuringTool.getTypeId());
        getOrganizationById(measuringTool, updateMeasuringTool.getOrganizationId());
        getUserById(measuringTool, updateMeasuringTool.getUserId());
        getManufacturerById(measuringTool, updateMeasuringTool.getManufacturerId());
        getOwnerById(measuringTool,updateMeasuringTool.getOwnerId());
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

    private void getControlTypeRepositoryById(MeasuringTool measuringTool, Long typId) {
        measuringTool.setType(controlTypeRepository.findById(typId)
                  .orElseThrow(() -> new NotFoundException(String.format("control type with id=%s not found", typId))));
    }

    private void getOrganizationById(MeasuringTool measuringTool, Long orgId) {
        measuringTool.setOrganization(organizationRepository.findById(orgId)
                  .orElseThrow(() -> new NotFoundException(String.format("organization with id=%s not found", orgId))));
    }

    private void getUserById(MeasuringTool measuringTool, Long userId) {
        measuringTool.setUser(userRepository.findById(userId)
                         .orElseThrow(() -> new NotFoundException(String.format("user with id=%s not found", userId))));
    }

    private void getManufacturerById(MeasuringTool measuringTool, Long manId) {
        measuringTool.setManufacturer(manufacturerRepository.findById(manId)
                  .orElseThrow(() -> new NotFoundException(String.format("manufacturer with id=%s not found", manId))));
    }

    private void getOwnerById(MeasuringTool measuringTool, Long ownerId) {
        measuringTool.setOwner(ownerRepository.findById(ownerId)
                       .orElseThrow(() -> new NotFoundException(String.format("owner with id=%s not found", ownerId))));
    }
}
