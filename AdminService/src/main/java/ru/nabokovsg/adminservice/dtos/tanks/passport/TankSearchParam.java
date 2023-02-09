package ru.nabokovsg.adminservice.dtos.tanks.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.tanks.Orientation;
import ru.nabokovsg.adminservice.models.tanks.TypeTank;

@Setter
@Getter
@AllArgsConstructor
public class TankSearchParam {

    private TypeTank typeTank;
    private Orientation orientation;
    private Integer volume;
    private Long addressId;
}
