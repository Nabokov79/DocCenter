package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.organizations.NewOrganizationDto;
import ru.nabokovsg.adminservice.dtos.organizations.OrganizationDto;
import ru.nabokovsg.adminservice.dtos.organizations.UpdateOrganizationDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.OrganizationMapper;
import ru.nabokovsg.adminservice.models.Organization;
import ru.nabokovsg.adminservice.repositoryes.OrganizationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;

    @Override
    public OrganizationDto save(NewOrganizationDto organizationDto) {
        if (repository.existsByName(organizationDto.getName())) {
            throw new BadRequestException(
                    String.format("organization=%s found.", organizationDto.getName())
            );
        }
        Organization organization = mapper.mapToNewOrganization(organizationDto);
        return mapper.mapToOrganizationDto(repository.save(organization));
    }

    @Override
    public OrganizationDto update(UpdateOrganizationDto organizationDto) {
        if (!repository.existsById(organizationDto.getId())) {
            throw new NotFoundException(
                    String.format("organization=%s not found for update.", organizationDto.getName())
            );
        }
        Organization organization = mapper.mapToUpdateOrganization(organizationDto);
        return mapper.mapToOrganizationDto(repository.save(organization));
    }

    @Override
    public List<OrganizationDto> getAll() {
        return mapper.mapToOrganizationsDto(repository.findAll());
    }

    @Override
    public String delete(Long orgId) {
        Organization organization = repository.findById(orgId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("organization with id=%s not found for delete.", orgId))
                );
        repository.deleteById(orgId);
        return organization.getName();
    }
}
