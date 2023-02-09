package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
