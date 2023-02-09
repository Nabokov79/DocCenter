package ru.nabokovsg.adminservice.dtos.pipelines.oilPipeline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.Address;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткое содержиние паспорта мазутопровода")
public class ShortOilPipelinePassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
}
