package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Element;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.ElementRepository;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;


    @Override
    public void save(Tables table, Set<Element> elements) {
        for (Element element : elements) {
            element.setTable(table);
        }
        repository.saveAll(elements);
    }
}
