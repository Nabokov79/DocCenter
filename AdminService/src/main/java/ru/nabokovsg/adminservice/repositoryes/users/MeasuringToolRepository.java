package ru.nabokovsg.adminservice.repositoryes.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;

import java.util.Set;

public interface MeasuringToolRepository extends JpaRepository<MeasuringTool, Long> {

    Set<MeasuringTool> findAllByUserId(Long userId);
}
