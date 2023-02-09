package ru.nabokovsg.adminservice.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CommonDto {

    private Author author;
    private Manufacturer manufacturer;
    private Mounting mounting;
    private Address address;
    private List<Survey> surveys;
    private List<Repair> repairs;
    private List<Documentation> documentation;
}
