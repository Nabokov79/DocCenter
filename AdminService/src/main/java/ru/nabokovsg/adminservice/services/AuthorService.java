package ru.nabokovsg.adminservice.services;

import ru.nabokovsg.adminservice.dtos.author.AuthorDto;
import ru.nabokovsg.adminservice.dtos.author.NewAuthorDto;
import ru.nabokovsg.adminservice.dtos.author.UpdateAuthorDto;
import java.util.List;

public interface AuthorService {

    AuthorDto save(NewAuthorDto authorDto);

    AuthorDto update(UpdateAuthorDto authorDto);

    List<AuthorDto> getAll();

    String delete(Long autId);
}
