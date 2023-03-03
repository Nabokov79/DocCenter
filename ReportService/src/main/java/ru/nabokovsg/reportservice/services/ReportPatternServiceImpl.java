package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.dtos.NewReportPatternDto;
import ru.nabokovsg.reportservice.dtos.ReportPatternDto;
import ru.nabokovsg.reportservice.dtos.UpdateReportPatternDto;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.exceptions.NotFoundException;
import ru.nabokovsg.reportservice.mappers.ReportPatternMapper;
import ru.nabokovsg.reportservice.models.PatternType;
import ru.nabokovsg.reportservice.models.ReportPattern;
import ru.nabokovsg.reportservice.repositoryes.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportPatternServiceImpl implements ReportPatternService {

    private final ReportPatternRepository repository;
    private final SectionsRepository sectionsRepository;
    private final ReportPatternMapper mapper;

    @Override
    public ReportPatternDto save(NewReportPatternDto patternDto) {
        PatternType patternType = getType(patternDto.getType());
        if (repository.existsByPatternType(patternType)) {
            throw new BadRequestException(String.format("report pattern for type=%s found", patternDto));
        }
        ReportPattern pattern = mapper.mapToReportPattern(patternDto);
        pattern.setPatternType(patternType);
        return mapper.mapToReportPatternDto(repository.save(pattern));
    }

    @Override
    public ReportPatternDto update(UpdateReportPatternDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("report pattern with id=%s not found for update.", patternDto.getId()));
        }
        ReportPattern pattern = mapper.fromUpdateReportPattern(patternDto);
        pattern.setPatternType(getType(patternDto.getType()));
        return mapper.mapToReportPatternDto(pattern);
    }

    @Override
    public ReportPatternDto get(Long patId) {
        ReportPattern pattern = repository.findById(patId)
                .orElseThrow(() -> new NotFoundException(String.format("pattern witch id=%s not found", patId)));
        log.info("Pattern = " + pattern);
        ReportPatternDto patternDto = mapper.mapToReportPatternDto(pattern);
        log.info("Pattern DTO = " + patternDto);
        return patternDto;
    }

    private PatternType getType(String type) {
        return PatternType.from(type)
                .orElseThrow(() -> new BadRequestException("Unknown type object: " + type));
    }
}
