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

    @Override
    public void save(Tables tables) {
        Tables tablesDb = repository.save(tables);
        tables.setTableColumns(tablesDb.getTableColumns());
        for(TableColumns columns : tables.getTableColumns()) {
            columns.setTables(tables);
        }
        columnsRepository.saveAll(tables.getTableColumns());
    }
}


