package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.Sections;
import ru.nabokovsg.reportservice.models.Subsections;

import java.util.List;

public interface SubsectionsService {

    void save(Sections section, List<Subsections> subsections);
}
