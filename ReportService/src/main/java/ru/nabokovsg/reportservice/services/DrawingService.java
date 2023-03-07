package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.Drawing;
import ru.nabokovsg.reportservice.models.Sections;

import java.util.List;

public interface DrawingService {

    void save(Sections section, List<Drawing> drawings);
}
