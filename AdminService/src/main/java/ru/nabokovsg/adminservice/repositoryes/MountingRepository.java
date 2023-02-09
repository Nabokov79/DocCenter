package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Mounting;

public interface MountingRepository extends JpaRepository<Mounting, Long> {

    boolean existsByName(String name);
}
