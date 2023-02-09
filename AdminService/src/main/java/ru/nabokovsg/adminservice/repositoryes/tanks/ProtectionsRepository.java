package ru.nabokovsg.adminservice.repositoryes.tanks;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.tanks.Protections;

public interface ProtectionsRepository extends JpaRepository<Protections, Long> {
}
