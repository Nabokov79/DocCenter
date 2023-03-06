package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
