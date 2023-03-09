package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
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
        validate(tables);
        for (SubTable subTable : tables) {
            subTable.setTables(table);
            elementService.save(repository.save(subTable), subTable.getElements());
        }
        return repository.saveAll(tables);
    }

    private void validate(Set<SubTable> subTables) {
        for (SubTable subTable : subTables) {
            if (subTable.getName() == null) {
                throw new BadRequestException("name sub table should not be null");
            }
            if (subTable.getElements().isEmpty()) {
                throw new BadRequestException("elements list in sub table should not be empty");
            }
        }
    }
}
