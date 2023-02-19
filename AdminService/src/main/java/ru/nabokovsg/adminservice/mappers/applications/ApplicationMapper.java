package ru.nabokovsg.adminservice.mappers.applications;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.applications.*;
import ru.nabokovsg.adminservice.models.applications.Application;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    Application mapToNewApplication(NewApplicationDto applicationDto);

    ApplicationDto mapToApplicationDto(Application application);

    Application mapToUpdateApplication(UpdateApplicationDto applicationDto);

    List<ApplicationDto> mapToApplicationsDto(List<Application> applications);
}
