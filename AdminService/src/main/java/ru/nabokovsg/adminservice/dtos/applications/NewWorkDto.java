package ru.nabokovsg.adminservice.dtos.applications;

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
@Schema(description = "Данные нового вмда работы")
public class NewWorkDto {

    @Schema(description = "Вид работы")
    @NotBlank(message = "name work should not be blank")
    private String name;
}
