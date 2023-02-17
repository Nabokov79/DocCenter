package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.reportsData.Param;
import ru.nabokovsg.adminservice.dtos.reportsData.ReportDataDto;

import java.util.List;

public interface ReportDataService {

    List<ReportDataDto> getAll(Param param);
}
