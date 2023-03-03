package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.dtos.NewSectionDto;
import ru.nabokovsg.reportservice.dtos.SectionDto;
import ru.nabokovsg.reportservice.dtos.UpdateSectionDto;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.exceptions.NotFoundException;
import ru.nabokovsg.reportservice.mappers.SectionsMapper;
import ru.nabokovsg.reportservice.models.ReportPattern;
import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.models.Subsections;
import ru.nabokovsg.reportservice.repositoryes.ReportPatternRepository;
import ru.nabokovsg.reportservice.repositoryes.SectionsRepository;
import ru.nabokovsg.reportservice.repositoryes.SubsectionsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionsServiceImpl implements SectionsService {

    private final SectionsRepository repository;
    private final ReportPatternRepository patternRepository;
    private final SubsectionsRepository subsectionsRepository;
    private final SectionsMapper mapper;
    private final TablesService tablesService;

    @Override
    public SectionDto save(NewSectionDto sectionDto) {
        ReportPattern pattern = getReportPattern(sectionDto.getReportPatternId());
        if (repository.existsByNumberSectionAndReportPattern(sectionDto.getNumberSection(), pattern)) {
            throw new BadRequestException(
                    String.format("section with number=%s for pattern with id=%s found", sectionDto.getNumberSection(),
                                                                                      sectionDto.getReportPatternId())
            );
        }
        Sections section = mapper.mapToSections(sectionDto);
        section.setReportPattern(pattern);
        repository.save(section);
        saveSubsections(section, sectionDto.getSubsections());
        return mapper.mapToSectionsDto(section);
    }

    @Override
    public SectionDto update(UpdateSectionDto sectionDto) {
        if (!repository.existsById(sectionDto.getId())) {
            throw new NotFoundException(
                    String.format("section with id=%s not found for update.", sectionDto.getId()));
        }
        Sections section = mapper.maoToUpdateSections(sectionDto);
        return mapper.mapToSectionsDto(repository.save(section));
    }

    @Override
    public SectionDto get(Long secId) {
        return mapper.mapToSectionsDto(repository.findById(secId)
                .orElseThrow(() -> new NotFoundException(String.format("sections witch id=%s not found", secId))));
    }

    private ReportPattern getReportPattern(Long id) {
        return patternRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("pattern witch id=%s not found", id)));
    }

    private void saveSubsections(Sections section, List<Subsections> subsections) {
        for (Subsections subsection : subsections) {
            subsection.setSections(section);
            if (subsection.getTables() != null) {
                tablesService.save(subsection.getTables());
            }
        }
        subsectionsRepository.saveAll(subsections);
    }
}
