package ru.nabokovsg.adminservice.dtos.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.users.ControlType;
import ru.nabokovsg.adminservice.models.Organization;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Возвращаемый сертификат аттестации сотрудника.")
public class CertificateDto {

    @Schema(description = "Индентификатор")
    private long id;
    @Schema(description = "Номер сертификата")
    private String number;
    @Schema(description = "Вид контроля соглано сертификата")
    private ControlType type;
    @Schema(description = "Квалификационный уровень сотрудника по данным из сертификата")
    private Integer level;
    @Schema(description = "Дата выдачи сертификата специализированной организацией")
    private LocalDate start;
    @Schema(description = "Дата окончания действия сертификата")
    private LocalDate end;
    @Schema(description = "Шифр объектов, для контроля которых допущен сотрудник согласно данным сертификата")
    private String points;
    @Schema(description = "Организация, выдавшая сертификат")
    private Organization organization;
}
