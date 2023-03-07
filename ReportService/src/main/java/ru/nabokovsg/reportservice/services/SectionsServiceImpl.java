package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.dtos.NewSectionDto;
import ru.nabokovsg.reportservice.dtos.SectionDto;
import ru.nabokovsg.reportservice.dtos.UpdateSectionDto;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.exceptions.NotFoundException;
import ru.nabokovsg.reportservice.mappers.ReportPatternMapper;
import ru.nabokovsg.reportservice.mappers.SectionsMapper;
import ru.nabokovsg.reportservice.models.ReportPattern;
import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.repositoryes.SectionsRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class SectionsServiceImpl implements SectionsService {

    private final SectionsRepository repository;
    private final SectionsMapper mapper;
    private final SubsectionsService subsectionsService;
    private final ReportPatternMapper reportPatternMapper;
    private final ReportPatternService reportPatternService;
    private final DrawingSectionService drawingSectionService;

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
        Sections sectionDb = repository.save(section);
        subsectionsService.save(sectionDb, sectionDto.getSubsections());
        drawingSectionService.save(sectionDb, sectionDto.getDrawings());
        return mapper.mapToSectionsDto(section);
    }

    @Override
    public SectionDto update(UpdateSectionDto sectionDto) {
        if (!repository.existsById(sectionDto.getId())) {
            throw new NotFoundException(
                    String.format("section with id=%s not found for update.", sectionDto.getId()));
        }
        Sections section = mapper.maoToUpdateSections(sectionDto);
        section.setReportPattern(getReportPattern(sectionDto.getReportPatternId()));
        Sections sectionDb = repository.save(section);
        subsectionsService.save(sectionDb, sectionDto.getSubsections());
        drawingSectionService.save(sectionDb, sectionDto.getDrawings());
        return mapper.mapToSectionsDto(section);
    }

    @Override
    public SectionDto get(Long secId) {
        return mapper.mapToSectionsDto(repository.findById(secId)
                .orElseThrow(() -> new NotFoundException(String.format("sections witch id=%s not found", secId))));
    }

    private ReportPattern getReportPattern(Long id) {
        return reportPatternMapper.toReportPattern(reportPatternService.get(id));
    }
}