package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.Element;
import ru.nabokovsg.reportservice.models.SubTable;
import ru.nabokovsg.reportservice.models.Tables;
import java.util.Set;

public interface ElementService {

    void save(Tables table, Set<Element> elements);
}
