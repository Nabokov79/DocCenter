package ru.nabokovsg.adminservice.dtos.tanks.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.tanks.Orientation;

@Setter
@Getter
@AllArgsConstructor
public class TankSearchParam {

    private Long typeId;
    private Orientation orientation;
    private Integer volume;
    private Long addressId;
}
