package ru.nabokovsg.adminservice.repositoryes.pipelines;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.pipelines.PipelinePassport;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;

public interface PipelinePassportRepository extends JpaRepository<PipelinePassport, Long> {

    boolean existsByPurposePipelineAndAddressAndLocation(PurposePipeline purposePipeline,
                                                         Address address,
                                                         String location);
}
