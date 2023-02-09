package ru.nabokovsg.adminservice.services.users;

import ru.nabokovsg.adminservice.dtos.users.NewOwnerDto;
import ru.nabokovsg.adminservice.dtos.users.OwnerDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateOwnerDto;
import java.util.List;

public interface OwnerService {

    OwnerDto save(NewOwnerDto ownerDto);

    OwnerDto update(UpdateOwnerDto ownerDto);

    List<OwnerDto> getAll();

    String delete(Long ownId);
}
