package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.models.Protocol;
import ru.nabokovsg.reportservice.models.Tables;
import ru.nabokovsg.reportservice.repositoryes.ProtocolRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProtocolServiceImpl implements ProtocolService {

    private final ProtocolRepository repository;
    private final TablesService tablesService;

    @Override
    public void save(List<Protocol> protocols) {
        for (Protocol protocol : protocols) {
            Protocol protocolDb = repository.save(protocol);
            for (Tables table : protocol.getTable()) {
                table.setProtocol(protocolDb);
                tablesService.save(table);
            }
        }
    }
}
