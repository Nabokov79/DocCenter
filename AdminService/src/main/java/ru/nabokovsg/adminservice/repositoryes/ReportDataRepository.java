package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.reports.ReportData;

public interface ReportDataRepository extends JpaRepository<ReportData, Long> {
}
