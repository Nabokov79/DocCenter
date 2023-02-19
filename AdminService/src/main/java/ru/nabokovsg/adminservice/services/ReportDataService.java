package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.reportsData.Param;
import ru.nabokovsg.adminservice.dtos.reportsData.ReportDataDto;
import ru.nabokovsg.adminservice.models.applications.Application;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReportDataService {

    List<ReportDataDto> getAll(Param param);

    void create(Application application);

    void update(HttpServletRequest request);
}
