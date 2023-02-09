package ru.nabokovsg.adminservice.mappers;

import org.mapstruct.Mapper;
import ru.nabokovsg.adminservice.dtos.author.AuthorDto;
import ru.nabokovsg.adminservice.dtos.author.NewAuthorDto;
import ru.nabokovsg.adminservice.dtos.author.UpdateAuthorDto;
import ru.nabokovsg.adminservice.models.Author;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author mapToNewAuthor(NewAuthorDto authorDto);

    AuthorDto mapToAuthorDto(Author author);

    Author mapToUpdateAuthor(UpdateAuthorDto authorDto);

    List<AuthorDto> mapToAuthorsDto(List<Author> authors);
}
