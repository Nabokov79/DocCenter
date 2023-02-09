package ru.nabokovsg.adminservice.dtos.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FilterIdsDto {

    private Long filterId;
    private Long dimensionsId;
}
