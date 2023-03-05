package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.models.Subsections;
import ru.nabokovsg.reportservice.repositoryes.SubsectionsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubsectionsServiceImpl implements SubsectionsService {

    private final SubsectionsRepository subsectionsRepository;
    private final TablesService tablesService;
    private final ConstantService constantService;

    @Override
    public void save(Sections section, List<Subsections> subsections) {
        for (Subsections subsection : subsections) {
            subsection.setSections(section);
            if (subsection.getTables() != null) {
                tablesService.save(subsection.getTables());
            }
            if (subsection.getConstant() != null) {
                constantService.save(subsection.getConstant());
            }
        }
        subsectionsRepository.saveAll(subsections);
    }
}
