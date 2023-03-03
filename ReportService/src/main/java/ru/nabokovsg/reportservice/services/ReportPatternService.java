package ru.nabokovsg.reportservice.services;

import org.springframework.web.bind.annotation.PathVariable;
import ru.nabokovsg.reportservice.dtos.NewReportPatternDto;
import ru.nabokovsg.reportservice.dtos.ReportPatternDto;
import ru.nabokovsg.reportservice.dtos.UpdateReportPatternDto;

public interface ReportPatternService {

    ReportPatternDto save(NewReportPatternDto patternDto);

    ReportPatternDto update(UpdateReportPatternDto patternDto);

    ReportPatternDto get(@PathVariable Long patId);
}
