package ru.nabokovsg.adminservice.dtos.mounting;

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
@Schema(description = "Данные новой монтажной организации")
public class NewMountingDto {

    @Schema(description = "Монтажная организация")
    @NotBlank(message = "name mounting organization should not be blank")
    private String name;
}
