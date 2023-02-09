package ru.nabokovsg.adminservice.services.users;

import ru.nabokovsg.adminservice.dtos.users.ControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.NewControlTypeDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateControlTypeDto;

import java.util.List;

public interface ControlTypeService {


    ControlTypeDto save(NewControlTypeDto typeControlDto);

    ControlTypeDto update(UpdateControlTypeDto typeControlDto);

    List<ControlTypeDto> getAll();

    String delete(Long typId);
}
