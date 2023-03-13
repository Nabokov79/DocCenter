package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.models.Columns;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.ColumnsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColumnsServiceImpl implements ColumnsService {

    private final ColumnsRepository repository;
    private final CombinedColumnsService combinedColumnsService;

    @Override
    public List<Columns> save(Tables table, List<Columns> columns) {
        log.info("Columns = " + columns);
        for (Columns column : columns) {
            validate(column);
            column.setTable(table);
        }
        return repository.saveAll(columns);
    }

    private void validate(Columns columns) {
        if (columns.getNumber() == null) {
            throw new BadRequestException("number column should not be blank");
        }
        if (columns.getNumber() < 0) {
            throw new BadRequestException("number column can only be positive");
        }
        if (columns.getName() == null) {
            throw new BadRequestException("name column should not be blank");
        }
    }
}
