package ru.nabokovsg.adminservice.dtos.tanks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TankIdsDto {

    private Long tankParametersId;
    private Long dimensionsId;
    private List<Long> beltsId;
    private List<Long> bottomsId;
    private Long protectionsId;
}