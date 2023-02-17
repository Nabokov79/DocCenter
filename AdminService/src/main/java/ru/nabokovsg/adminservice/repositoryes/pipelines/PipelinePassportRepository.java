package ru.nabokovsg.adminservice.repositoryes.pipelines;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.Type;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;

public interface PipelinePassportRepository extends JpaRepository<PipelinePassport, Long> {

    boolean existsByTypeAndAddressAndLocation(Type type, Address address, String location);
}
