package ru.nabokovsg.adminservice.mappers.applications;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.applications.NewWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.UpdateWorkDto;
import ru.nabokovsg.adminservice.dtos.applications.WorkDto;
import ru.nabokovsg.adminservice.models.applications.Work;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkMapper {

    Work mapToNewWork(NewWorkDto workDto);

    WorkDto mapToWorkDto(Work work);

    Work mapToUpdateWork(UpdateWorkDto workDto);

    List<WorkDto> mapToWorksDto(List<Work> works);
}
