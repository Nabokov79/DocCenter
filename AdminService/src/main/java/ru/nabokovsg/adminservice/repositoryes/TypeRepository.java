package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

    boolean existsByName(String name);
}
