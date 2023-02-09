package ru.nabokovsg.adminservice.repositoryes.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.users.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    boolean existsByName(String name);
}
