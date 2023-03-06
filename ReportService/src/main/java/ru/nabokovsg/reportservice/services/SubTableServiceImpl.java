package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.SubTable;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.SubTableRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubTableServiceImpl implements SubTableService {

    private final SubTableRepository repository;
    private final ElementService elementService;

    @Override
    public List<SubTable> save(Tables table, Set<SubTable> tables) {
        for (SubTable subTable : tables) {
            subTable.setTables(table);
            elementService.saveFromSubTable(repository.save(subTable), subTable.getElements());
        }
        return repository.saveAll(tables);
    }
}
