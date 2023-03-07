package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Drawing;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {
}
