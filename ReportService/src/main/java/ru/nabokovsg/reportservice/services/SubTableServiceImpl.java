package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.models.SubTable;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.SubTableRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubTableServiceImpl implements SubTableService {

    private final SubTableRepository repository;

    @Override
    public List<SubTable> save(Tables table, List<SubTable> tables) {
        validate(tables);
        for (SubTable subTable : tables) {
            subTable.setTable(table);
        }
        return repository.saveAll(tables);
    }

    private void validate(List<SubTable> subTables) {
        for (SubTable subTable : subTables) {
            if (subTable.getName() == null) {
                throw new BadRequestException("name sub table should not be null");
            }
        }
    }
}
