package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.Element;
import ru.nabokovsg.reportservice.models.SubTable;

import java.util.Set;

public interface ElementService {

    void save(SubTable subTable, Set<Element> elements);
}
