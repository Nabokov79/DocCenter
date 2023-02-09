package ru.nabokovsg.adminservice.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.users.NewUserDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateUserDto;
import ru.nabokovsg.adminservice.dtos.users.UserShortDto;
import ru.nabokovsg.adminservice.dtos.users.UserDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.users.UserMapper;
import ru.nabokovsg.adminservice.models.users.MeasuringTool;
import ru.nabokovsg.adminservice.models.users.User;
import ru.nabokovsg.adminservice.repositoryes.users.CertificateRepository;
import ru.nabokovsg.adminservice.repositoryes.users.MeasuringToolRepository;
import ru.nabokovsg.adminservice.repositoryes.users.UserRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CertificateRepository certificateRepository;
    private final MeasuringToolRepository measuringToolRepository;
    private final UserMapper mapper;

    @Override
    public UserShortDto save(NewUserDto user) {
        if (repository.existsByServiceNumber(user.getServiceNumber())) {
            throw new BadRequestException(String.format("user=%s found.", user));
        }
        User userDb = repository.save(mapper.mapToUser(user));
        return mapper.mapToUserShortDto(userDb);
    }

    @Override
    public UserShortDto update(UpdateUserDto user) {
        if (!repository.existsById(user.getId())) {
            throw new NotFoundException(String.format("user with id=%s not found for update", user.getId()));
        }
        User userDb = repository.save(mapper.mapToUpdateUser(user));
        return mapper.mapToUserShortDto(userDb);
    }

    @Override
    public UserDto get(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User with id=%s was not found", userId)));
        return mapper.mapToUserDto(user);
    }

    @Override
    public List<UserShortDto> getAll() {
        return repository.findAll().stream().map(mapper::mapToUserShortDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long userId) {
        if (repository.existsById(userId)) {
            updateMeasuringTool(userId);
            certificateRepository.deleteAllByUserId(userId);
            repository.deleteById(userId);
            return;
        }
        throw new NotFoundException(String.format("user with id = %s not found for delete", userId));
    }

    private void updateMeasuringTool(Long userId) {
        Set<MeasuringTool> measuringTools = measuringToolRepository.findAllByUserId(userId);
        measuringTools.forEach(measuringTool -> measuringTool.setUser(null));
        measuringToolRepository.saveAll(measuringTools);
    }
}
