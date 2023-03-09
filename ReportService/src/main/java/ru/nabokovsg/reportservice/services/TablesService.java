package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.ReportPattern;
import ru.nabokovsg.reportservice.models.Tables;

public interface TablesService {

    void save(ReportPattern pattern, Tables tables);
}
