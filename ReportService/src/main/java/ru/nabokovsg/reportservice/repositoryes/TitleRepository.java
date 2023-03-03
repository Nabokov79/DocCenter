package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
