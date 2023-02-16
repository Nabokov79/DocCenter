package ru.nabokovsg.adminservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.License;

import java.time.LocalDate;

public interface LicenseRepository extends JpaRepository<License, Long> {

    boolean existsByDate(LocalDate date);
}
