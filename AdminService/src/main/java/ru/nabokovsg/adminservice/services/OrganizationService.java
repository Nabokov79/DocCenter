package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.organizations.NewOrganizationDto;
import ru.nabokovsg.adminservice.dtos.organizations.OrganizationDto;
import ru.nabokovsg.adminservice.dtos.organizations.UpdateOrganizationDto;
import java.util.List;

public interface OrganizationService {

    OrganizationDto save(NewOrganizationDto organizationDto);

    OrganizationDto update(UpdateOrganizationDto organizationDto);

    List<OrganizationDto> getAll();

    String delete(Long orgId);
}
