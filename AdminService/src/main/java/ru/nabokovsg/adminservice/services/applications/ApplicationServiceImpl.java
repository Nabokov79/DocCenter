package ru.nabokovsg.adminservice.services.applications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.applications.ApplicationDto;
import ru.nabokovsg.adminservice.dtos.applications.ApplicationSearchParam;
import ru.nabokovsg.adminservice.dtos.applications.NewApplicationDto;
import ru.nabokovsg.adminservice.dtos.applications.UpdateApplicationDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.applications.ApplicationMapper;
import ru.nabokovsg.adminservice.models.applications.Application;
import ru.nabokovsg.adminservice.models.applications.PassportType;
import ru.nabokovsg.adminservice.models.tanks.Orientation;
import ru.nabokovsg.adminservice.repositoryes.applications.ApplicationRepository;
import ru.nabokovsg.adminservice.services.ReportDataService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;
    private final ReportDataService reportDataService;
    private final ApplicationMapper mapper;

    @Override
    public ApplicationDto save(NewApplicationDto applicationDto) {
        Application application = repository.save(setValues(mapper.mapToNewApplication(applicationDto),
                                                            applicationDto.getPassportType(),
                                                            applicationDto.getOrientation()));
        reportDataService.create(application);
        return mapper.mapToApplicationDto((application));
    }

    @Override
    public ApplicationDto update(UpdateApplicationDto applicationDto) {
        if (!repository.existsById(applicationDto.getId())) {
            throw new NotFoundException(
                                 String.format("application with id=%s not found for update", applicationDto.getId()));
        }
        Application application = setValues(mapper.mapToUpdateApplication(applicationDto),
                                            applicationDto.getPassportType(),
                                            applicationDto.getOrientation());
        return mapper.mapToApplicationDto(repository.save(application));
    }

    @Override
    public List<ApplicationDto> getAll(ApplicationSearchParam param) {
        return null;
    }

    private Application setValues(Application application, String passportType, String orientation) {
        application.setPassportType(PassportType.from(passportType)
                .orElseThrow(() -> new BadRequestException("Unknown passport type object: " + passportType)));
        application.setOrientation(Orientation.from(orientation)
                .orElseThrow(() -> new BadRequestException("Unknown orientation object: " + orientation)));
        return application;
    }
}