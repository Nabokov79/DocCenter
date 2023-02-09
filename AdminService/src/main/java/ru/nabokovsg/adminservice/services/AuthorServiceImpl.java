package ru.nabokovsg.adminservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.author.AuthorDto;
import ru.nabokovsg.adminservice.dtos.author.NewAuthorDto;
import ru.nabokovsg.adminservice.dtos.author.UpdateAuthorDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.AuthorMapper;
import ru.nabokovsg.adminservice.models.Author;
import ru.nabokovsg.adminservice.repositoryes.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorDto save(NewAuthorDto authorDto) {
        if (repository.existsByName(authorDto.getName())) {
            throw new BadRequestException(String.format("author=%s found.", authorDto.getName()));
        }
        Author author = mapper.mapToNewAuthor(authorDto);
        return mapper.mapToAuthorDto(repository.save(author));
    }

    @Override
    public AuthorDto update(UpdateAuthorDto authorDto) {
        if (!repository.existsById(authorDto.getId())) {
            throw new NotFoundException(String.format("author=%s not found for update.", authorDto.getName()));
        }
        Author author = mapper.mapToUpdateAuthor(authorDto);
        return mapper.mapToAuthorDto(repository.save(author));
    }

    @Override
    public List<AuthorDto> getAll() {
        return mapper.mapToAuthorsDto(repository.findAll());
    }

    @Override
    public String delete(Long autId) {
        Author author = repository.findById(autId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("author with id=%s not found for delete.", autId))
                );
        repository.deleteById(autId);
        return author.getName();
    }
}
