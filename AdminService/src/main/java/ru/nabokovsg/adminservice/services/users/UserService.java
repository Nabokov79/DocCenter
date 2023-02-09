package ru.nabokovsg.adminservice.services.users;

import ru.nabokovsg.adminservice.dtos.users.NewUserDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateUserDto;
import ru.nabokovsg.adminservice.dtos.users.UserDto;
import ru.nabokovsg.adminservice.dtos.users.UserShortDto;
import java.util.List;

public interface UserService {

    UserShortDto save(NewUserDto user);

    UserShortDto update(UpdateUserDto user);

    UserDto get(Long userId);

    List<UserShortDto> getAll();

    void delete(Long userId);
}
