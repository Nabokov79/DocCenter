package ru.nabokovsg.adminservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DivisionIds {

    private Long cityId;
    private Long organizationId;
    private Long licenseId;
}
