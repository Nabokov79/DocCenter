package ru.nabokovsg.adminservice.dtos.reportsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class Param {

    private Long applicationId;
    private Long userId;
    private Long addressId;
    private Integer number;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
