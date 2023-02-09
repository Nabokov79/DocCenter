package ru.nabokovsg.adminservice.dtos.manufacturers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового изготовителя")
public class NewManufacturerDto {

    @Schema(description = "Изготовитель")
    @NotBlank(message = "name manufacturer should not be blank")
    private String name;
}
