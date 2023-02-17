package ru.nabokovsg.adminservice.dtos.types;

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
@Schema(description = "Данные нового типа объекта")
public class NewTypeDto {

    @Schema(description = "Тип объекта")
    @NotBlank(message = "name type should not be blank")
    private String name;
}
