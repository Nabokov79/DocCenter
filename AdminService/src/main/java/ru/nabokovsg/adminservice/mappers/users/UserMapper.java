package ru.nabokovsg.adminservice.mappers.users;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.users.NewUserDto;
import ru.nabokovsg.adminservice.dtos.users.UpdateUserDto;
import ru.nabokovsg.adminservice.dtos.users.UserDto;
import ru.nabokovsg.adminservice.dtos.users.UserShortDto;
import ru.nabokovsg.adminservice.models.users.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToUser(NewUserDto newUser);

    UserDto mapToUserDto(User user);

    User mapToUpdateUser(UpdateUserDto userDto);

    UserShortDto mapToUserShortDto(User user);
}
