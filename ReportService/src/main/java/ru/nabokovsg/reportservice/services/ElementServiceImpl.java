package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Element;
import ru.nabokovsg.reportservice.models.SubTable;
import ru.nabokovsg.reportservice.repositoryes.ElementRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;

    @Override
    public void save(SubTable subTable, Set<Element> elements) {
        for (Element element : elements) {
            element.setSubTable(subTable);
        }
        repository.saveAll(elements);
    }
}
