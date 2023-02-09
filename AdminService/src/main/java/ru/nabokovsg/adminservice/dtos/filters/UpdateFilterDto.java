package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о фильтре")
public class UpdateFilterDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "filter id should not be blank")
    @Positive(message = "filter id must be positive")
    private Long id;
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
        return "UpdateFilterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
