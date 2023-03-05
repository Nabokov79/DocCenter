package ru.nabokovsg.reportservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.reportservice.dtos.NewReportPatternDto;
import ru.nabokovsg.reportservice.dtos.ReportPatternDto;
import ru.nabokovsg.reportservice.dtos.UpdateReportPatternDto;
import ru.nabokovsg.reportservice.models.ReportPattern;

@Mapper(componentModel = "spring")
public interface ReportPatternMapper {

    ReportPattern mapToReportPattern(NewReportPatternDto patternDto);

    ReportPatternDto mapToReportPatternDto(ReportPattern pattern);

    ReportPattern fromUpdateReportPattern(UpdateReportPatternDto patternDto);
}
