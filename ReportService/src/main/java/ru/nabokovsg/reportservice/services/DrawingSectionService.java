package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.DrawingSection;
import java.util.Set;

public interface DrawingSectionService {

    void save(Set<DrawingSection> drawings);
}
