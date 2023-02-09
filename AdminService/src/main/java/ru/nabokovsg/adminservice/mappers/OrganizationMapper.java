package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.organizations.NewOrganizationDto;
import ru.nabokovsg.adminservice.dtos.organizations.OrganizationDto;
import ru.nabokovsg.adminservice.dtos.organizations.UpdateOrganizationDto;
import ru.nabokovsg.adminservice.models.Organization;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    Organization mapToNewOrganization(NewOrganizationDto organizationDto);

    OrganizationDto mapToOrganizationDto(Organization organization);

    Organization mapToUpdateOrganization(UpdateOrganizationDto organizationDto);

    List<OrganizationDto> mapToOrganizationsDto(List<Organization> organization);
}
