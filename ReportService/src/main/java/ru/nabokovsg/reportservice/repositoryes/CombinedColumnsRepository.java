package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.CombinedColumns;

public interface CombinedColumnsRepository extends JpaRepository<CombinedColumns, Long> {
}
