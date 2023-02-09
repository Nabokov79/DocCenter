package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByName(String name);
}
