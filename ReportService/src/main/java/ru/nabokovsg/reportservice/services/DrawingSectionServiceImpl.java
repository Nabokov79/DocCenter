package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Drawing;
import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.repositoryes.DrawingSectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrawingSectionServiceImpl implements DrawingSectionService {

    private final DrawingSectionRepository repository;

    @Override
    public void save(Sections section, List<Drawing> drawings) {
        if (drawings != null) {
            for (Drawing drawing : drawings) {
                drawing.setSections(section);
            }
            repository.saveAll(drawings);
        }
    }
}
