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
    private final ReportPatternMapper mapper;

    @Override
    public ReportPatternDto save(NewReportPatternDto patternDto) {
        PatternType type = getType(patternDto.getType());
        if (repository.existsByType(type)) {
            throw new BadRequestException(String.format("report pattern for type=%s found", patternDto));
        }
        ReportPattern pattern = mapper.mapToReportPattern(patternDto);
        pattern.setType(type);
        return mapper.mapToReportPatternDto(repository.save(pattern));
    }

    @Override
    public ReportPatternDto update(UpdateReportPatternDto patternDto) {
        if (!repository.existsById(patternDto.getId())) {
            throw new NotFoundException(
                    String.format("report pattern with id=%s not found for update.", patternDto.getId()));
        }
        ReportPattern pattern = mapper.fromUpdateReportPattern(patternDto);
        pattern.setType(getType(patternDto.getType()));
        return mapper.mapToReportPatternDto(pattern);
    }

    @Override
    public ReportPatternDto get(Long patId) {
        return mapper.mapToReportPatternDto(repository.findById(patId)
                .orElseThrow(() -> new NotFoundException(String.format("pattern witch id=%s not found", patId))));
    }


    private PatternType getType(String type) {
        return PatternType.from(type)
                .orElseThrow(() -> new BadRequestException("Unknown type object: " + type));
    }
}
