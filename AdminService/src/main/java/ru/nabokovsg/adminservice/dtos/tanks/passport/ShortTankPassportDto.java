package ru.nabokovsg.adminservice.dtos.tanks.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.tanks.TankParameters;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткое содержиние паспорта бака")
public class ShortTankPassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер бака")
    private Integer tankNumber;
    @Schema(description = "Параметры бака")
    private TankParameters tankParameters;
    @Schema(description = "Адрес местонахождения котельной")
    private Address address;
}
