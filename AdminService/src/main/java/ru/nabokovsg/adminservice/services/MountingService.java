package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.mounting.MountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.NewMountingDto;
import ru.nabokovsg.adminservice.dtos.mounting.UpdateMountingDto;

import java.util.List;

public interface MountingService {

    MountingDto save(NewMountingDto mountingDto);

    MountingDto update(UpdateMountingDto mountingDto);

    List<MountingDto> getAll();

    String delete(Long mouId);
}
