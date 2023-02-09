package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokovsg.adminservice.models.documentation.Documentation;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {

    @Query("select d from Documentation d where d.typeDocument = ?1 and d.numberDocument = ?2")
    boolean existsByTypeDocumentAndAndNumberDocument(String typeDocument, String numberDocument);
}
