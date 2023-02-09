package ru.nabokovsg.adminservice.repositoryes.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.users.ControlType;

public interface ControlTypeRepository extends JpaRepository<ControlType, Long> {

    boolean existsByName(String name);
}
