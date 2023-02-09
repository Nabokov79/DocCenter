package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.repairs.NewRepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.RepairDto;
import ru.nabokovsg.adminservice.dtos.repairs.UpdateRepairDto;

public interface RepairService {

    RepairDto save(NewRepairDto repairDto);

    RepairDto update(UpdateRepairDto repairDto);

    void delete(Long repId);
}
