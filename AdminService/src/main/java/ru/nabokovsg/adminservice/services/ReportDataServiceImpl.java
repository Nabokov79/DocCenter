package ru.nabokovsg.adminservice.services;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.adminservice.dtos.reportsData.Param;
import ru.nabokovsg.adminservice.dtos.reportsData.ReportDataDto;
import ru.nabokovsg.adminservice.exceptions.BadRequestException;
import ru.nabokovsg.adminservice.mappers.ReportDataMapper;
import ru.nabokovsg.adminservice.models.reports.QReportData;
import ru.nabokovsg.adminservice.models.reports.ReportData;
import ru.nabokovsg.adminservice.models.reports.Status;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportDataServiceImpl implements ReportDataService {

    private final ReportDataMapper mapper;
    private final EntityManager entityManager;

    @Override
    public List<ReportDataDto> getAll(Param param) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (param.getApplicationId() != null) {
            booleanBuilder.and(QReportData.reportData.application.id.eq(param.getApplicationId()));
        }
        if (param.getUserId() != null) {
            booleanBuilder.and(QReportData.reportData.user.id.eq(param.getUserId()));
        }
        if (param.getAddressId() != null) {
            booleanBuilder.and(QReportData.reportData.application.address.id.eq(param.getAddressId()));
        }
        if (param.getNumber() != null) {
            booleanBuilder.and(QReportData.reportData.number.eq(param.getNumber()));
        }
        if (param.getStatus() != null) {
            Status status = Status.from(param.getStatus())
                    .orElseThrow(() -> new BadRequestException("Unknown type object: " + param.getStatus()));
            booleanBuilder.and(QReportData.reportData.status.eq(status));
        }
        QReportData reportData = QReportData.reportData;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<ReportData> query = qf.from(reportData)
                                       .select(reportData)
                                       .where(booleanBuilder);
        return mapper.mapToReportsDataDto(query.fetch());
    }
}
