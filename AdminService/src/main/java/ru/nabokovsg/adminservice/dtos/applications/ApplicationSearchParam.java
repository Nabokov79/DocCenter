package ru.nabokovsg.adminservice.dtos.applications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class ApplicationSearchParam {

    private Long addressId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean primary;
    private Boolean repeat;
    private String passport;
}
