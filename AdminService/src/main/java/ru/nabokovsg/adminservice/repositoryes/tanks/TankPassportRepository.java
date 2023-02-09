package ru.nabokovsg.adminservice.repositoryes.tanks;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.tanks.TankPassport;

public interface TankPassportRepository extends JpaRepository<TankPassport, Long> {
}
