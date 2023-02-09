package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового фильтра")
public class NewFilterDto {

    @Schema(description = "Тип фильтра")
    @NotBlank(message = "type filter should not be blank")
    private String type;
    @Schema(description = "Назначение фильтра")
    @NotBlank(message = "name filter should not be blank")
    private String name;
    @Schema(description = "Модель фильтра")
    private String model;

    @Override
    public String toString() {
        return "NewFilterDto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
