package ru.nabokovsg.adminservice.services.tanks;

import ru.nabokovsg.adminservice.dtos.tanks.protections.NewProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.ProtectionsDto;
import ru.nabokovsg.adminservice.dtos.tanks.protections.UpdateProtectionsDto;
import java.util.List;

public interface ProtectionsService {

    ProtectionsDto save(NewProtectionsDto protectionsDto);

    ProtectionsDto update(UpdateProtectionsDto protectionsDto);

    List<ProtectionsDto> getAll();

    void delete(Long proId);
}
