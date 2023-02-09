package ru.nabokovsg.adminservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestIds {

    private Long authorId;
    private Long manufacturerId;
    private Long mountingId;
    private Long addressId;
    private List<Long> surveysId;
    private List<Long> repairsId;
    private List<Long> documentationId;
}
