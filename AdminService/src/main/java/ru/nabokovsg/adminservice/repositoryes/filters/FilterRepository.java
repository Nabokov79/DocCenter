package ru.nabokovsg.adminservice.repositoryes.filters;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Type;
import ru.nabokovsg.adminservice.models.filters.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {

    boolean existsByTypeAndModel(Type type, String model);
}
