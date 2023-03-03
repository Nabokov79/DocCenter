package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.DrawingSection;

public interface DrawingSectionRepository extends JpaRepository<DrawingSection, Long> {
}
