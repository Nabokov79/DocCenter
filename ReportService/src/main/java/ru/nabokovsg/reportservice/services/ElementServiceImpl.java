package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Defect;
import ru.nabokovsg.reportservice.models.Element;
import ru.nabokovsg.reportservice.models.SubTable;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.DefectRepository;
import ru.nabokovsg.reportservice.repositoryes.ElementRepository;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;
    private final DefectRepository defectRepository;

    @Override
    public void saveFromTable(Tables table, Set<Element> elements) {
        for (Element element : elements) {
            element.setTables(table);
            save(element);
        }
    }

    @Override
    public void saveFromSubTable(SubTable subTable, Set<Element> elements) {
        if (elements != null && !elements.isEmpty()) {
            for (Element element : elements) {
                element.setSubTable(subTable);
                save(element);
            }
        }
    }

    private void save(Element element) {
        if (element != null) {
            Element elementDb = repository.save(element);
            for (Defect defect: element.getDefect()) {
                defect.setElement(elementDb);
            }
            defectRepository.saveAll(element.getDefect());
        }
    }
}
