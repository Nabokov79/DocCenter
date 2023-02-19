package ru.nabokovsg.adminservice.repositoryes.applications;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.applications.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {

    boolean existsByName(String name);
}
