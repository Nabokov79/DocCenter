package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Element;
import ru.nabokovsg.reportservice.models.PatternType;

import java.util.Set;

public interface ElementRepository extends JpaRepository<Element, Long> {

    Set<Element> findAllByType(PatternType type);
}
