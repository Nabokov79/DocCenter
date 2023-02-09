package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные фильтра")
public class FilterDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип фильтра")
    private String type;
    @Schema(description = "Назначение фильтра")
    private String name;
    @Schema(description = "Модель фильтра")
    private String model;
}
