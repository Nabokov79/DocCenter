package ru.nabokovsg.adminservice.services.applications;

import ru.nabokovsg.adminservice.dtos.applications.ApplicationDto;
import ru.nabokovsg.adminservice.dtos.applications.ApplicationSearchParam;
import ru.nabokovsg.adminservice.dtos.applications.NewApplicationDto;
import ru.nabokovsg.adminservice.dtos.applications.UpdateApplicationDto;
import java.util.List;

public interface ApplicationService {

    ApplicationDto save(NewApplicationDto applicationDto);

   ApplicationDto update(UpdateApplicationDto applicationDto);

   List<ApplicationDto> getAll(ApplicationSearchParam param);
}
