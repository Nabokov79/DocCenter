package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.reportsData.ReportDataDto;
import ru.nabokovsg.adminservice.models.reports.ReportData;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportDataMapper {

    List<ReportDataDto> mapToReportsDataDto(List<ReportData> reportData);
}
