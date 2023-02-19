package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.nabokovsg.adminservice.models.reports.ReportData;

public interface ReportDataRepository extends JpaRepository<ReportData, Long>, QuerydslPredicateExecutor<ReportData> {

}
