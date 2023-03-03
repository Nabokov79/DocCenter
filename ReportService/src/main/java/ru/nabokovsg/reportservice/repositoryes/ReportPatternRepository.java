package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.PatternType;
import ru.nabokovsg.reportservice.models.ReportPattern;

public interface ReportPatternRepository extends JpaRepository<ReportPattern, Long> {

    boolean existsByPatternType(PatternType patternType);
}
