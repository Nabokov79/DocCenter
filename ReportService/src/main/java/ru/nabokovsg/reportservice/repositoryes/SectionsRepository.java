package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.ReportPattern;
import ru.nabokovsg.reportservice.models.Sections;

public interface SectionsRepository extends JpaRepository<Sections, Long> {

    boolean existsByNumberSectionAndReportPattern(Integer numberSection, ReportPattern reportPattern);
}
