package ru.nabokovsg.adminservice.repositoryes.pipelines;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;

public interface PurposePipelineRepository extends JpaRepository<PurposePipeline, Long> {

    boolean existsByName(String name);
}
