package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Division;
import ru.nabokovsg.adminservice.models.License;

public interface DivisionRepository extends JpaRepository<Division, Long> {

    boolean existsByLicenseAndBranch(License license, String branch);
}
