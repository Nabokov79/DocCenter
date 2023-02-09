package ru.nabokovsg.adminservice.dtos.pipelines;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.pipelines.PurposePipeline;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткое содержиние паспорта трубопровода")
public class ShortPipelinePassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название назначения трубопровода")
    private PurposePipeline purpose;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
    @Schema(description = "Местоположение трубопровода на территории котельной")
    private String location;
}
