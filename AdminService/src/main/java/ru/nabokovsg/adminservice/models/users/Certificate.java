package ru.nabokovsg.adminservice.models.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Organization;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private String number;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "control_type_id", referencedColumnName = "id")
    private ControlType type;
    @Column(name = "level")
    private Integer level;
    @Column(name = "start_date")
    private LocalDate start;
    @Column(name = "end_date")
    private LocalDate end;
    @Column(name = "points")
    private String points;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;
}
