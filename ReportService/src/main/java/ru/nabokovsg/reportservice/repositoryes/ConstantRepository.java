package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Constant;

public interface ConstantRepository extends JpaRepository<Constant, Long> {
}
