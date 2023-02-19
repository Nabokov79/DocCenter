package ru.nabokovsg.adminservice.repositoryes.applications;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.applications.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
