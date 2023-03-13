package ru.nabokovsg.reportservice.services;

import ru.nabokovsg.reportservice.models.Protocol;

import java.util.List;

public interface ProtocolService {

    void save(List<Protocol> protocols);
}
