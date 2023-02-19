package ru.nabokovsg.adminservice.models.applications;

import lombok.*;
import ru.nabokovsg.adminservice.models.Type;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.tanks.Orientation;
import ru.nabokovsg.adminservice.models.users.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    private Work work;
    @Column(name = "passport_type")
    @Enumerated(EnumType.STRING)
    private PassportType passportType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @Column(name = "passport_id")
    private Long passportId;
    @Column(name = "number")
    private Integer number;
    @Column(name = "orientation")
    @Enumerated(EnumType.STRING)
    private Orientation orientation;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "primary_visit")
    private Boolean primary;
    @Column(name = "repeat_visit")
    private Boolean repeat;
    @Column(name = "note")
    private String note;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "applications_users",
            joinColumns =  {@JoinColumn(name = "application_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    @ToString.Exclude
    private List<User> users;
}
