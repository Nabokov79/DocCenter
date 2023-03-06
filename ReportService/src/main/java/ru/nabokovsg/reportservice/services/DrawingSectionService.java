package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.DrawingSection;
import java.util.List;

public interface DrawingSectionService {

    void save(List<DrawingSection> drawings);
}
