package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.TableColumns;

public interface TableColumnsRepository extends JpaRepository<TableColumns, Long> {
}
