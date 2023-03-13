package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Columns;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.TablesRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TablesServiceImpl implements TablesService {

    private final TablesRepository repository;
    private final ColumnsService columnsService;
    private final SubTableService subTableService;

    @Override
    public Tables save(Tables table) {
        Tables tableDb = repository.save(table);
        List<Columns> columns = table.getColumns().stream().toList();
        if (table.getSubTables() != null) {
            subTableService.save(tableDb, table.getSubTables());
        }
        columnsService.save(tableDb, columns);
        return table;
    }
}