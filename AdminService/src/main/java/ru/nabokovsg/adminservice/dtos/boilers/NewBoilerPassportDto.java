package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового паспорта котла")
public class NewBoilerPassportDto {

    @Schema(description = "Индентификатор котла")
    @NotNull(message = "boiler id should not be blank")
    @Positive(message = "boiler id must be positive")
    private Long boilerId;
    @Schema(description = "Индентификатор автора проекта")
    private Long authorId;
    @Schema(description = "Номер проекта")
    private String projectNumber;
    @Schema(description = "Индентификатор завода изготовителя котла")
    private Long manufacturerId;
    @Schema(description = "Индентификатор монтажной организации")
    private Long mountingId;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Список индентификаторов обследований котла")
    private List<Long> surveysId;
    @Schema(description = "Список индентификаторов ремонтов котла")
    private List<Long> repairsId;
    @Schema(description = "Список индентификаторов нормативных документов")
    @NotNull(message = "documentation should not be blank")
    private List<Long> documentationId;
}
