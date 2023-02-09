package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.repairs.NewRepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.RepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.UpdateRepairDto;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.RepairMapper;
import ru.nabokovsg.adminservice.models.Repair;
import ru.nabokovsg.adminservice.models.Organization;
import ru.nabokovsg.adminservice.repositoryes.OrganizationRepository;
import ru.nabokovsg.adminservice.repositoryes.RepairRepository;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repository;
    private final OrganizationRepository organizationRepository;
    private final RepairMapper mapper;

    @Override
    public RepairDto save(NewRepairDto repairDto) {
        Repair repair = mapper.mapToNewRepair(repairDto);
        repair.setOrganization(getOrganization(repairDto.getOrganizationId()));
        return mapper.mapToRepairDto(repository.save(repair));
    }

    @Override
    public RepairDto update(UpdateRepairDto repairDto) {
        if (repository.existsById(repairDto.getId())) {
            throw new NotFoundException(String.format("repair with id=%s not found for update", repairDto.getId()));
        }
        Repair repair = mapper.mapToUpdateRepair(repairDto);
        return mapper.mapToRepairDto(repository.save(repair));
    }

    @Override
    public void delete(Long repId) {
        if (repository.existsById(repId)) {
            repository.deleteById(repId);
        }
        throw new NotFoundException(String.format("repair with id=%s not found for delete", repId));
    }

    private Organization getOrganization(Long orgId) {
        return organizationRepository.findById(orgId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("organization with id=%s not found.", orgId))
                );
    }
}
