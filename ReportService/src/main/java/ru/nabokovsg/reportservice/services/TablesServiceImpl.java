package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Columns;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.ColumnsRepository;
import ru.nabokovsg.reportservice.repositoryes.TablesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TablesServiceImpl implements TablesService {

    private final TablesRepository repository;
    private final ColumnsService columnsService;
    private final ColumnsRepository columnsRepository;

    @Override
    public void save(List<Tables> tables) {
        log.info("Tables = " + tables);
        for (Tables table : tables) {
            log.info("Before table columns = " + table.getColumns());
            saveColumns(table.getColumns());
            Tables tableDb = repository.save(table);
            tableDb.setColumns(table.getColumns());
        }
    }

    public void saveColumns(List<Columns> columns) {
        log.info("Table columns = " + columns);
        columnsRepository.saveAll(columns);
    }
}