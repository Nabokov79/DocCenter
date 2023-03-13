package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.SubTable;
import ru.nabokovsg.reportservice.models.Tables;
import java.util.List;

public interface SubTableService {

    List<SubTable> save(Tables table, List<SubTable> tables);
}
