package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.models.Subsections;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.SubsectionsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubsectionsServiceImpl implements SubsectionsService {

    private final SubsectionsRepository subsectionsRepository;
    private final TablesService tablesService;

    @Override
    public void save(Sections section, List<Subsections> subsections) {
        if (subsections != null && !subsections.isEmpty()) {
            for (Subsections subsection : subsections) {
                subsection.setSections(section);
                Subsections subsectionDb = subsectionsRepository.save(subsection);
                if(subsection.getTables() != null) {
                    for (Tables table : subsection.getTables()) {
                        table.setSubsections(subsectionDb);
                    }
                    tablesService.save(subsection.getTables());
                }
            }
            subsectionsRepository.saveAll(subsections);
        }
    }
}
