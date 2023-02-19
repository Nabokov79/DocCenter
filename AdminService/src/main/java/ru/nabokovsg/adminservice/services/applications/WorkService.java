package ru.nabokovsg.adminservice.services.applications;

import ru.nabokovsg.adminservice.dtos.applications.NewWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.UpdateWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.WorkDto;
import java.util.List;

public interface WorkService {

    WorkDto save(NewWorkDto workDto);

    WorkDto update(UpdateWorkDto workDto);

    List<WorkDto> getAll();

    void delete(Long worId);
}
