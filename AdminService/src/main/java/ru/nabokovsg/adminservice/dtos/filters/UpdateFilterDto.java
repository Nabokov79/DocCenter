package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
    @Schema(description = "Индентификатор типа фильтра")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id must be positive")
    private Long typeId;

    @Schema(description = "Модель фильтра")
    private String model;

    @Override
    public String toString() {
        return "UpdateFilterDto{" +
                "id=" + id +
                ", typeId='" + typeId + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
