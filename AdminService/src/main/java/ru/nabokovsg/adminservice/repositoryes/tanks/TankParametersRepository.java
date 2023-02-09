package ru.nabokovsg.adminservice.repositoryes.tanks;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.tanks.TankParameters;

public interface TankParametersRepository extends JpaRepository<TankParameters, Long> {
}
