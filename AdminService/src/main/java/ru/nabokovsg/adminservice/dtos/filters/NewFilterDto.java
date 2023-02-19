package ru.nabokovsg.adminservice.dtos.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового фильтра")
public class NewFilterDto {

    @Schema(description = "Тип фильтра")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id must be positive")
    private Long typeId;

    @Schema(description = "Модель фильтра")
    private String model;

    @Override
    public String toString() {
        return "NewFilterDto{" +
                "typeId=" + typeId +
                ", model='" + model + '\'' +
                '}';
    }
}
