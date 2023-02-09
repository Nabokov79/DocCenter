package ru.nabokovsg.adminservice.repositoryes.boilers;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.boilers.Boiler;

public interface BoilerRepository extends JpaRepository<Boiler, Long> {
}
