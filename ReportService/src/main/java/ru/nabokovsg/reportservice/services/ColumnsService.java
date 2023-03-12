package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.Columns;
import ru.nabokovsg.reportservice.models.Tables;

import java.util.List;

public interface ColumnsService {

    List<Columns> save(List<Columns> columns);
}
