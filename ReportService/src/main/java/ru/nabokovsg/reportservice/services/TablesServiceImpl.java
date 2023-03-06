package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.TableColumns;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.TableColumnsRepository;
import ru.nabokovsg.reportservice.repositoryes.TablesRepository;

@Service
@RequiredArgsConstructor
public class TablesServiceImpl implements TablesService {

    private final TablesRepository repository;
    private final TableColumnsRepository columnsRepository;
    private final SubTableService subTableService;
    private final ElementService elementService;

    @Override
    public void save(Tables tables) {
        Tables tablesDb = repository.save(tables);
        tablesDb.setTableColumns(tables.getTableColumns());
        for(TableColumns columns : tablesDb.getTableColumns()) {
            columns.setTables(tablesDb);
        }
        columnsRepository.saveAll(tablesDb.getTableColumns());
        if (tables.getElements() != null) {
            elementService.saveFromTable(tablesDb, tables.getElements());
        } else if (tables.getSubTables() != null){
            subTableService.save(tablesDb,tables.getSubTables());
        }
    }
}


