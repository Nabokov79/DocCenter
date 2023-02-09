package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.repairs.NewRepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.RepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.UpdateRepairDto;
import ru.nabokovsg.adminservice.models.Repair;

@Mapper(componentModel = "spring")
public interface RepairMapper {

    Repair mapToNewRepair(NewRepairDto repairDto);

    RepairDto mapToRepairDto(Repair repair);

    Repair mapToUpdateRepair(UpdateRepairDto repairDto);
}
