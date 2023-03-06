package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {
}
