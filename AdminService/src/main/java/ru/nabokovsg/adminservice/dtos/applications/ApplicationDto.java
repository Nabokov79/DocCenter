package ru.nabokovsg.adminservice.dtos.applications;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Type;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.applications.Work;
import ru.nabokovsg.adminservice.models.tanks.Orientation;
import ru.nabokovsg.adminservice.models.users.User;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ApplicationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Дата проведения работ")
    private LocalDate date;
    @Schema(description = "Индентификатор адреса местонахождения котельной")
    private Address address;
    @Schema(description = "Вид проводимых работ")
    private Work work;
    @Schema(description = "Тип объекта обследования")
    private Type type;
    @Schema(description = "Объем бака, деаэратора")
    private Integer volume;
    @Schema(description = "Положение бака, деаэратора")
    private Orientation orientation;
    @Schema(description = "Первичное обсдедование")
    private Boolean primary;
    @Schema(description = "Повторное обследование")
    private Boolean repeat;
    @Schema(description = "Примечание")
    private String note;
    @Schema(description = "Сотрудники, проводившие обследование")
    private List<User> users;
}
