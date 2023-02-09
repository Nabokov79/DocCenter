package ru.nabokovsg.adminservice.repositoryes.pipelines;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;
import ru.nabokovsg.adminservice.models.pipelines.StandardNormPipe;

import java.util.List;

public interface StandardNormPipeRepository extends JpaRepository<StandardNormPipe, Long> {


    List<StandardNormPipe> findAllByPurpose(PurposePipeline purpose);

}
