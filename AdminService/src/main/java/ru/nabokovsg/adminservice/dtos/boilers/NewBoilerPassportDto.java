package ru.nabokovsg.adminservice.dtos.boilers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @Schema(description = "Индентификатор автора проекта")
    @Positive(message = "author id can only be positive")
    private Long authorId;
    @Schema(description = "номер проекта")
    @Min(value = 1, message = "less than one character entered")
    private String projectNumber;
    @Schema(description = "Индентификатор завода изготовителя фильтра")
    @Positive(message = "manufacturer id can only be positive")
    private Long manufacturerId;
    @Schema(description = "Индентификатор монтажной организации")
    @Positive(message = "mounting id can only be positive")
    private Long mountingId;
    @Schema(description = "Дата ввода в эксплуатацию")
    private LocalDate operation;
    @Schema(description = "Дата составления паспорта")
    private LocalDate startPassport;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long addressId;
    @Schema(description = "Список индентификаторов обследований")
    private List<Long> surveysId;
    @Schema(description = "Список индентификаторов ремонтов бака")
    private List<Long> repairsId;
    @Schema(description = "Список индентификаторов нормативных документов")
    @NotNull(message = "documentation should not be blank")
    private List<Long> documentationId;

    @Override
    public String toString() {
        return "NewBoilerPassportDto{" +
                "boilerId=" + boilerId +
                ", authorId=" + authorId +
                ", projectNumber='" + projectNumber + '\'' +
                ", manufacturerId=" + manufacturerId +
                ", mountingId=" + mountingId +
                ", operation=" + operation +
                ", startPassport=" + startPassport +
                ", addressId=" + addressId +
                ", surveysId=" + surveysId +
                ", repairsId=" + repairsId +
                ", documentationId=" + documentationId +
                '}';
    }
}
