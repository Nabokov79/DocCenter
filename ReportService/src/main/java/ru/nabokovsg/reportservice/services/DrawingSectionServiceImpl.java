package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.DrawingSection;
import ru.nabokovsg.reportservice.repositoryes.DrawingSectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrawingSectionServiceImpl implements DrawingSectionService {

    private final DrawingSectionRepository repository;

    @Override
    public void save(List<DrawingSection> drawing) {
        repository.saveAll(drawing);
    }
}
