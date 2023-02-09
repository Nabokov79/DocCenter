package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    boolean existsByName(String name);
}
