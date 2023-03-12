package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Columns;

public interface ColumnsRepository extends JpaRepository<Columns, Long> {
}
