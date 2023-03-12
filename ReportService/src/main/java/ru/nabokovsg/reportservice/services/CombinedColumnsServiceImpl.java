package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.models.CombinedColumns;
import ru.nabokovsg.reportservice.repositoryes.CombinedColumnsRepository;

@Service
@RequiredArgsConstructor
public class CombinedColumnsServiceImpl implements CombinedColumnsService {

    private final CombinedColumnsRepository repository;

    @Override
    public CombinedColumns save(CombinedColumns columns) {
        validate(columns);
        return repository.save(columns);
    }

    private void validate(CombinedColumns columns) {
        if (columns.getFirst() == null) {
            throw new BadRequestException("number first column section should not be blank");
        }
        if (columns.getFirst() < 0) {
            throw new BadRequestException("number first column section can only be positive");
        }
        if (columns.getSecond() == null) {
            throw new BadRequestException("number second column section should not be blank");
        }
        if (columns.getSecond() < 0) {
            throw new BadRequestException("number second column section can only be positive");
        }
        if (columns.getName() == null) {
            throw new BadRequestException("name combined column section should not be blank");
        }
    }
}
