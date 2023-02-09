package ru.nabokovsg.adminservice.repositoryes.pipelines;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.pipelines.OilPipelinePassport;

public interface OilPipelinePassportRepository extends JpaRepository<OilPipelinePassport, Long> {

    boolean existsByAddress(Address address);
}
