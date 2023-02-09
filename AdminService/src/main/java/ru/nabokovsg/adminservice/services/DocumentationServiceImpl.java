package ru.nabokovsg.adminservice.services;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.documentation.DocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.NewDocumentationDto;
import ru.nabokovsg.adminservice.dtos.documentation.UpdateDocumentationDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.exceptions.NotFoundException;
import ru.nabokovsg.adminservice.mappers.DocumentationMapper;
import ru.nabokovsg.adminservice.models.documentation.Documentation;
import ru.nabokovsg.adminservice.models.documentation.QDocumentation;
import ru.nabokovsg.adminservice.models.documentation.TypeObject;
import ru.nabokovsg.adminservice.repositoryes.DocumentationRepository;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentationServiceImpl implements DocumentationService {

    private final DocumentationRepository repository;

    private final DocumentationMapper mapper;
    private final EntityManager entityManager;

    @Override
    public DocumentationDto save(NewDocumentationDto documentationDto, String typeObject) {
        if (repository.existsByTypeDocumentAndAndNumberDocument(documentationDto.getTypeDocument(),
                documentationDto.getNumberDocument())) {
            throw new BadRequestException(
                    String.format("document %s %s found", documentationDto.getTypeDocument(),
                                                          documentationDto.getNumberDocument())
            );
        }
        Documentation documentation = setValues(mapper.mapToNewDocumentation(documentationDto),
                                               getTypeObject(typeObject));
        return mapper.mapToDocumentationDto(repository.save(documentation));
    }

    @Override
    public DocumentationDto update(UpdateDocumentationDto documentationDto, String typeObject) {
        if (repository.existsById(documentationDto.getId())) {
            throw new BadRequestException(
                    String.format("document %s %s not found for update", documentationDto.getTypeDocument(),
                                                                         documentationDto.getNumberDocument())
            );
        }
        Documentation documentation = setValues(mapper.mapToUpdateDocumentation(documentationDto),
                                               getTypeObject(typeObject));
        return mapper.mapToDocumentationDto(repository.save(documentation));
    }

    @Override
    public List<DocumentationDto> getAll(String typeObject, String typeDocument, String numberDocument) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (typeObject != null) {
            booleanBuilder.and(QDocumentation.documentation.typeObject.eq(getTypeObject(typeObject)));
        }
        if (typeDocument != null) {
            booleanBuilder.and(QDocumentation.documentation.typeDocument.eq(typeDocument));
        }
        if (numberDocument != null) {
            booleanBuilder.and(QDocumentation.documentation.numberDocument.eq(numberDocument));
        }
        QDocumentation documentation = QDocumentation.documentation;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<Documentation> query = qf.from(documentation)
                .select(documentation)
                .where(booleanBuilder);
        return mapper.mapToDocumentationsDto(query.fetch());
    }

    @Override
    public String delete(Long docId) {
        Documentation documentation = repository.findById(docId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("document with id=%s not found for delete.", docId))
                );
        repository.deleteById(docId);
        return String.join(" ", documentation.getTypeDocument(), documentation.getNumberDocument());
    }

    private Documentation setValues(Documentation documentation, TypeObject typeObject) {
        documentation.setTypeDocument(documentation.getTypeDocument().toUpperCase());
        documentation.setTypeObject(typeObject);
        return documentation;
    }

    private TypeObject getTypeObject(String typeObject) {
        return TypeObject.from(typeObject)
                .orElseThrow(() -> new BadRequestException("Unknown type object: " + typeObject));
    }
}
