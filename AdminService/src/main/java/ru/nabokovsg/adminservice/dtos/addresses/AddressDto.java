package ru.nabokovsg.adminservice.dtos.addresses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.addresses.City;
import ru.nabokovsg.adminservice.models.addresses.TypeBuilding;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные адреса")
public class AddressDto {

    @Schema(description = "Индентификатор города")
    private Long id;
    @Schema(description = "Населенный пункт")
    private City city;
    @Schema(description = "Тип строения")
    private TypeBuilding typeBuilding;
    @Schema(description = "Название котельной")
    private String login;
    @Schema(description = "Название улицы")
    private String street;
    @Schema(description = "Номер дома")
    private Integer houseNumber;
    @Schema(description = "Номер корпуса дома")
    private Integer buildingNumber;
    @Schema(description = "Литера дома")
    private String letter;
}
