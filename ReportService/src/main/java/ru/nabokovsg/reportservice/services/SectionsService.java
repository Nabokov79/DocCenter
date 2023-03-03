package ru.nabokovsg.reportservice.services;

import org.springframework.web.bind.annotation.PathVariable;
import ru.nabokovsg.reportservice.dtos.*;

public interface SectionsService {

    SectionDto save(NewSectionDto sectionDto);

    SectionDto update(UpdateSectionDto sectionDto);

    SectionDto get(@PathVariable Long secId);
}
