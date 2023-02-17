package ru.nabokovsg.adminservice.dtos.pipelines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PipelineIdsDto {

    private Long typeId;
    private List<Long> standardNormPipesId;
}
