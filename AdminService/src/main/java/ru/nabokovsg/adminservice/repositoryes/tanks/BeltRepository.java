package ru.nabokovsg.adminservice.repositoryes.tanks;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.tanks.Belt;

public interface BeltRepository extends JpaRepository<Belt, Long> {
}
