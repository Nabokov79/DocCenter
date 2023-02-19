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
import ru.nabokovsg.adminservice.models.applications.Application;
import ru.nabokovsg.adminservice.models.reports.QReportData;
import ru.nabokovsg.adminservice.models.reports.ReportData;
import ru.nabokovsg.adminservice.models.reports.Status;
import ru.nabokovsg.adminservice.repositoryes.ReportDataRepository;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportDataServiceImpl implements ReportDataService {

    private final ReportDataRepository repository;
    private final ReportDataMapper mapper;
    private final EntityManager entityManager;

    @Override
    public List<ReportDataDto> getAll(Param param) {
        QReportData reportData = QReportData.reportData;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        JPAQuery<ReportData> query = qf.from(reportData)
                                       .select(reportData)
                                       .where(getPredicate(param));
        return mapper.mapToReportsDataDto(query.fetch());
    }

    @Override
    public void create(Application application) {
        ReportData report = new ReportData();
        report.setApplication(application);
        report.setStatus(Status.WAITING);
        report.setNumber(getMaxReportNumber() + 1);
        repository.save(report);
    }

    @Override
    public void update(HttpServletRequest request) {

    }

    private Integer getMaxReportNumber() {
        QReportData reportData = QReportData.reportData;
        JPAQueryFactory qf = new JPAQueryFactory(entityManager);
        return qf.from(reportData)
                .select(reportData.number.max())
                .where(QReportData.reportData.application.date.after(LocalDate.now().minusYears(1)))
                .fetchOne();
    }

    private BooleanBuilder getPredicate(Param param) {
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
        if (param.getStartDate() != null) {
            booleanBuilder.and(QReportData.reportData.endTime.before(param.getStartDate().minusDays(1)));
        }
        if (param.getEndDate() != null) {
            booleanBuilder.and(QReportData.reportData.endTime.after(param.getEndDate().plusDays(1)));
        }
        if (param.getStatus() != null) {
            Status status = Status.from(param.getStatus())
                    .orElseThrow(() -> new BadRequestException("Unknown type object: " + param.getStatus()));
            booleanBuilder.and(QReportData.reportData.status.eq(status));
        }
        return booleanBuilder;
    }
}
