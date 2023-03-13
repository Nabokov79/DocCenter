package ru.nabokovsg.reportservice.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.reportservice.models.Protocol;

public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
}
