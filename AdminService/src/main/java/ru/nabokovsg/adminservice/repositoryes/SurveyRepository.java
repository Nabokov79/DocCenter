package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
