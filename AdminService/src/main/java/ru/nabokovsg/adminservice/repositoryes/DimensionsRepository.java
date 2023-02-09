package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Dimensions;

public interface DimensionsRepository extends JpaRepository<Dimensions, Long> {
}
